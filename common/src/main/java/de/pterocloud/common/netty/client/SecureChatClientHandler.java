package de.pterocloud.common.netty.client;

import com.google.gson.Gson;
import de.pterocloud.common.netty.packet.Packet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.AllArgsConstructor;

/**
 * Handles a client-side channel.
 */
@AllArgsConstructor
public class SecureChatClientHandler extends SimpleChannelInboundHandler<String> {

    private ChatClient client;

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        client.getPacketListener().receivePacket(new Gson().fromJson(msg, Packet.class));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause) {
        cause.printStackTrace();
        channelHandlerContext.close();
    }

}
