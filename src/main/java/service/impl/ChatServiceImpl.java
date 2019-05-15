package service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import model.mapper.GroupInfoMapper;
import model.mapper.UserInfoMapper;
import model.po.GroupInfo;
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
        LOGGER.info("程序执行singleSend");
        String fromUserId = param.get("fromUserId").toString();
        LOGGER.info(fromUserId);
        String toUserId = param.get("toUserId").toString();
        LOGGER.info(toUserId);
        String content = param.get("content").toString();
        LOGGER.info(content);
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
            sendMessage(toUserCtx, responseJson);
        }
    }

    @Override
    public void groupSend(JSONObject param, ChannelHandlerContext ctx) {
    }

    @Override
    public void FileMsgSingleSend(JSONObject param, ChannelHandlerContext ctx) {

    }

    @Override
    public void FileMsgGroupSend(JSONObject param, ChannelHandlerContext ctx) {

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
