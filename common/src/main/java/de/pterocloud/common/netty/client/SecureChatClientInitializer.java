package de.pterocloud.common.netty.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.base64.Base64Decoder;
import io.netty.handler.codec.base64.Base64Encoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslContext;
import lombok.AllArgsConstructor;

/**
 * Creates a newly configured {@link ChannelPipeline} for a new channel.
 */
@AllArgsConstructor
public class SecureChatClientInitializer extends ChannelInitializer<SocketChannel> {

    private final SslContext sslCtx;
    private final ChatClient client;

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // Add SSL handler first to encrypt and decrypt everything.
        // In this example, we use a bogus certificate in the server side
        // and accept any invalid certificates in the client side.
        // You will need something more complicated to identify both
        // and server in the real world.
        pipeline.addLast(sslCtx.newHandler(ch.alloc(), client.getHost(), client.getPort()));


        pipeline.addLast(new Base64Decoder());
        pipeline.addLast(new Base64Encoder());
        pipeline.addLast(new StringDecoder());
        pipeline.addLast(new StringEncoder());

        // and then business logic.
        pipeline.addLast(new SecureChatClientHandler(client));
    }
}
