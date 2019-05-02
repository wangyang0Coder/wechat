package Netty;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Author: Azhu
 * @Date: 2019/5/3 1:28
 * Description:存储Netty工程的全局配置
 */
public class NettyConfig {
    /**
     * 存储每一个客户端接入进来是的channel对象
     */
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
