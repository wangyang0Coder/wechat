package service;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import model.po.GroupInfo;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/9 10:09
 * Description:
 */
public interface ChatService {
    public void register(JSONObject param, ChannelHandlerContext ctx);

    public void singleSend(JSONObject param, ChannelHandlerContext ctx);

    public void groupSend(JSONObject param, ChannelHandlerContext ctx);

    public void FileMsgSingleSend(JSONObject param, ChannelHandlerContext ctx);

    public void FileMsgGroupSend(JSONObject param, ChannelHandlerContext ctx);

    public void remove(ChannelHandlerContext ctx);

    public void typeError(ChannelHandlerContext ctx);

    List<GroupInfo> listAll();
}
