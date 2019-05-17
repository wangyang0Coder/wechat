package web.websocket;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.*;
import model.vo.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.ChatService;
import util.Constant;

/**
 * @Author: Azhu
 * @Date: 2019/5/7 14:04
 * Description:
 */
@Component
@ChannelHandler.Sharable
public class WebSocketServerHandler extends SimpleChannelInboundHandler<WebSocketFrame> {


    private static final Logger logger= LoggerFactory.getLogger(WebSocketServerHandler.class);

    @Autowired
    private ChatService chatService;
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame) throws Exception {
        handlerWebSocketFrame(channelHandlerContext, webSocketFrame);
    }

    /**
     * 描述: 处理WebSocketFrame
     * @param ctx
     * @param frame
     */
    private void handlerWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        // 关闭请求
        if (frame instanceof CloseWebSocketFrame) {
            WebSocketServerHandshaker handshaker =
                    Constant.webSocketHandshakerMap.get(ctx.channel().id().asLongText());
            if (handshaker == null) {
                sendErrorMessage(ctx, "不存在的客户端连接！");
            } else {
                handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            }
            return;
        }
        // ping请求
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        // 只支持文本格式，不支持二进制消息
        if (!(frame instanceof TextWebSocketFrame)) {
            sendErrorMessage(ctx, "仅支持文本(Text)格式，不支持二进制消息");
            return;
        }

        // 客服端发送过来的消息
        String request = ((TextWebSocketFrame)frame).text();
        logger.info("服务端收到新信息：" + request);
        JSONObject param = null;
        try {
            param = JSONObject.parseObject(request);
        } catch (Exception e) {
            sendErrorMessage(ctx, "JSON字符串转换出错！");
            e.printStackTrace();
        }
        if (param == null) {
            sendErrorMessage(ctx, "参数为空！");
            return;
        }
        String type = (String) param.get("type");
        switch (type) {
            case "LOGIN"://登录消息
                chatService.login(param, ctx);
                break;
            case "SINGLE_SENDING"://单体消息发送
                chatService.singleSend(param, ctx);
                break;
            case "GROUP_SENDING"://群组消息发送
                chatService.groupSend(param, ctx);
                break;
            case "FILE_MSG_SINGLE_SENDING"://单体文件发送
                chatService.FileMsgSingleSend(param, ctx);
                break;
            case "FILE_MSG_GROUP_SENDING"://群组文件发送
                chatService.FileMsgGroupSend(param, ctx);
                break;
            default:
                chatService.typeError(ctx);
                break;
        }
    }
    private void sendErrorMessage(ChannelHandlerContext ctx, String errorMsg) {
        String responseJson = new ResponseJson()
                .error(errorMsg)
                .toString();
        ctx.channel().writeAndFlush(new TextWebSocketFrame(responseJson));
    }
}
