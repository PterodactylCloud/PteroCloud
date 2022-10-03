package de.pterocloud.common.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Handles a server-side channel.
 */
public class SecureChatServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
