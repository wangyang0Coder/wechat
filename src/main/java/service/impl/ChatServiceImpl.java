package service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import model.mapper.GroupInfoMapper;
import model.mapper.MessageInfoMapper;
import model.mapper.UserInfoMapper;
import model.po.Belong;
import model.po.GroupInfo;
import model.po.MessageInfo;
import model.po.UserInfo;
import model.vo.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ChatService;
import util.ChatType;
import util.Constant;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: Azhu
 * @Date: 2019/5/9 10:12
 * Description:
 */
@Service
public class ChatServiceImpl implements ChatService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired
    private GroupInfoMapper groupInfoMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private MessageInfoMapper messageInfoMapper;

    @Override
    public void login(JSONObject param, ChannelHandlerContext ctx) {
        String userId = param.get("userId").toString();
        Constant.onlineUserMap.put(userId, ctx);
        String responseJson = new ResponseJson().success()
                .setData("type", ChatType.LOGIN)
                .toString();
        sendMessage(ctx, responseJson);
        LOGGER.info(MessageFormat.format("userId为 {0} 的用户登记到在线用户表，当前在线人数为：{1}"
                , userId, Constant.onlineUserMap.size()));
    }

    @Override
    public void singleSend(JSONObject param, ChannelHandlerContext ctx) {

        String fromUserId = param.get("fromUserId").toString();
        String toUserId = param.get("toUserId").toString();
        String content = param.get("content").toString();
        ChannelHandlerContext toUserCtx = Constant.onlineUserMap.get(toUserId);
        if (toUserCtx == null) {
            String responseJson = new ResponseJson()
                    .error(MessageFormat.format("userId为 {0} 的用户没有登录！", toUserId))
                    .toString();
            sendMessage(ctx, responseJson);
        } else {
            String responseJson = new ResponseJson().success()
                    .setData("fromUserId", fromUserId)
                    .setData("content", content)
                    .setData("type", ChatType.SINGLE_SENDING)
                    .toString();
            MessageInfo messageInfo=new MessageInfo(fromUserId,toUserId,content,ChatType.SINGLE_SENDING);
            messageInfoMapper.insert(messageInfo);
            sendMessage(toUserCtx, responseJson);
        }
    }

    @Override
    public void groupSend(JSONObject param, ChannelHandlerContext ctx) {
        String fromUserId = param.get("fromUserId").toString();
        String toGroupId = (String) param.get("toGroupId").toString();
        String content = (String) param.get("content");
        Integer togrouId = Integer.parseInt(toGroupId);
        Integer fromuserId = Integer.parseInt(fromUserId);
        GroupInfo groupInfo = groupInfoMapper.getByGroupId(togrouId);
        String responseJson = new ResponseJson().success()
                .setData("fromUserId", fromUserId)
                .setData("content", content)
                .setData("toGroupId", toGroupId)
                .setData("type", ChatType.GROUP_SENDING)
                .toString();
        MessageInfo messageInfo=new MessageInfo(fromUserId,toGroupId,content,ChatType.GROUP_SENDING);
        messageInfoMapper.insert(messageInfo);

        groupInfo.getMembers().stream()//使用JDK1.8 lambda 新语法
                .forEach(member -> {
                    ChannelHandlerContext toCtx = Constant.onlineUserMap.get(String.valueOf(member.getUserInfo().getUserId()));//userID是long类型的应该转化为String
                    if (toCtx != null && member.getUserInfo().getUserId() != (fromuserId)) {//不等与发送者就转发
                        //System.out.println("转发");
                        LOGGER.info(groupInfo.getGroupName() + "群组消息:" + String.valueOf(fromuserId) + "--->" + String.valueOf(member.getUserInfo().getUserId()));
                        sendMessage(toCtx, responseJson);
                    }
                });
        /*List<Belong> Members = groupInfo.getMembers();
            for (Belong member : Members) {
            ChannelHandlerContext toCtx = Constant.onlineUserMap.get(String.valueOf(member.getUserInfo().getUserId()));//userID是long类型的应该转化为String
            if (toCtx != null && member.getUserInfo().getUserId() != (fromuserId)) {//不等与发送者就转发
                //System.out.println("转发");
                LOGGER.info(groupInfo.getGroupName() + "群组消息:" + String.valueOf(fromuserId) + "--->" + String.valueOf(member.getUserInfo().getUserId()));
                sendMessage(toCtx, responseJson);

            }
        }*/
    }

    @Override
    public void FileMsgSingleSend(JSONObject param, ChannelHandlerContext ctx) {
        String fromUserId = param.get("fromUserId").toString();
        String toUserId = param.get("toUserId").toString();
        String originalFilename = (String) param.get("originalFilename");
        String fileSize = (String) param.get("fileSize");
        String fileUrl = (String) param.get("fileUrl");
        ChannelHandlerContext toUserCtx = Constant.onlineUserMap.get(toUserId);
        if (toUserCtx == null) {
            String responseJson = new ResponseJson()
                    .error(MessageFormat.format("userId为 {0} 的用户没有登录！", toUserId))
                    .toString();
            sendMessage(ctx, responseJson);
        } else {
            String responseJson = new ResponseJson().success()
                    .setData("fromUserId", fromUserId)
                    .setData("originalFilename", originalFilename)
                    .setData("fileSize", fileSize)
                    .setData("fileUrl", fileUrl)
                    .setData("type", ChatType.FILE_MSG_SINGLE_SENDING)
                    .toString();
            MessageInfo messageInfo=new MessageInfo(fromUserId,toUserId,originalFilename,fileSize,fileUrl,ChatType.FILE_MSG_SINGLE_SENDING);
            messageInfoMapper.insert(messageInfo);
            sendMessage(toUserCtx, responseJson);
        }
    }

    @Override
    public void FileMsgGroupSend(JSONObject param, ChannelHandlerContext ctx) {
        String fromUserId = param.get("fromUserId").toString();
        String toGroupId = param.get("toGroupId").toString();
        String originalFilename = (String) param.get("originalFilename");
        String fileSize = (String) param.get("fileSize");
        String fileUrl = (String) param.get("fileUrl");
        GroupInfo groupInfo = groupInfoMapper.getByGroupId(Integer.valueOf(toGroupId));
        String responseJson = new ResponseJson().success()
                .setData("fromUserId", fromUserId)
                .setData("toGroupId", toGroupId)
                .setData("originalFilename", originalFilename)
                .setData("fileSize", fileSize)
                .setData("fileUrl", fileUrl)
                .setData("type", ChatType.FILE_MSG_GROUP_SENDING)
                .toString();
        MessageInfo messageInfo=new MessageInfo(fromUserId,toGroupId,originalFilename,fileSize,fileUrl,ChatType.FILE_MSG_GROUP_SENDING);
        messageInfoMapper.insert(messageInfo);
        groupInfo.getMembers().stream()
                .forEach(member -> {
                    ChannelHandlerContext toCtx = Constant.onlineUserMap.get(String.valueOf(member.getUserInfo().getUserId()));
                    if (toCtx != null && member.getUserInfo().getUserId() != Long.parseLong(fromUserId)) {
                        sendMessage(toCtx, responseJson);
                    }
                });

    }

    @Override
    public void remove(ChannelHandlerContext ctx) {
        Iterator<Map.Entry<String, ChannelHandlerContext>> iterator =
                Constant.onlineUserMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ChannelHandlerContext> entry = iterator.next();
            if (entry.getValue() == ctx) {
                LOGGER.info("正在移除握手实例...");
                Constant.webSocketHandshakerMap.remove(ctx.channel().id().asLongText());
                LOGGER.info(MessageFormat.format("已移除握手实例，当前握手实例总数为：{0}"
                        , Constant.webSocketHandshakerMap.size()));
                iterator.remove();
                LOGGER.info(MessageFormat.format("userId为 {0} 的用户已退出聊天，当前在线人数为：{1}"
                        , entry.getKey(), Constant.onlineUserMap.size()));
                break;
            }
        }
    }

    @Override
    public void typeError(ChannelHandlerContext ctx) {
        String responseJson = new ResponseJson()
                .error("该类型不存在！")
                .toString();
        sendMessage(ctx, responseJson);
    }

    private void sendMessage(ChannelHandlerContext ctx, String message) {

        ctx.channel().writeAndFlush(new TextWebSocketFrame(message));
    }

    @Override
    public List<GroupInfo> listAll() {
        return groupInfoMapper.listAll();
    }


}
