package service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.netty.channel.ChannelHandlerContext;
import model.mapper.GroupInfoMapper;
import model.mapper.UserInfoMapper;
import model.po.GroupInfo;
import model.po.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ChatService;

import java.util.List;

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
    public void register(JSONObject param, ChannelHandlerContext ctx) {
        String userName = (String) param.get("userName");
        String password = (String) param.get("password");
        UserInfo userInfo = new UserInfo(userName, password);
        userInfoMapper.insert(userInfo);//插入数据库
    }

    @Override
    public void singleSend(JSONObject param, ChannelHandlerContext ctx) {

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

    }

    @Override
    public void typeError(ChannelHandlerContext ctx) {

    }

    @Override
    public List<GroupInfo> listAll() {
        return groupInfoMapper.listAll();
    }


}
