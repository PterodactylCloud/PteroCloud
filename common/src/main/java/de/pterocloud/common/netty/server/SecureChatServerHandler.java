package de.pterocloud.common.netty.server;

import com.google.gson.Gson;
import de.pterocloud.common.netty.packet.Packet;
import de.pterocloud.common.netty.packet.PacketListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Handles a server-side channel.
 */
public class SecureChatServerHandler extends SimpleChannelInboundHandler<String> {


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //PacketListener.onPacketReceive(ctx, new Gson().fromJson(msg, Packet.class));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
