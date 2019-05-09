package service.impl;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import model.mapper.GroupInfoMapper;
import model.po.GroupInfo;
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
    @Override
    public void register(JSONObject param, ChannelHandlerContext ctx) {

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
