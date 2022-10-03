package de.pterocloud.common.netty.client;

import com.google.gson.Gson;
import de.pterocloud.common.netty.packet.Packet;
import de.pterocloud.common.netty.packet.PacketListener;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public final class ChatClient {

    //TODO: remove?
//    private UUID clientID;
//
//    private UUID serverID;

    private final String host;

    private final int port;

    private final PacketListener packetListener;

    private EventLoopGroup group;

    private Channel channel;

    public void start() throws Exception {

        log.debug("Creating SSL context");
        final SslContext sslCtx = SslContextBuilder.forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        log.debug("SSL context created");

        group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new SecureChatClientInitializer(sslCtx, this));

        // Start the connection attempt.
        log.debug("Try to connect to server: {}:{}", host, port);
        channel = bootstrap.connect(host, port).sync().channel();
        log.info("Connected to server");


    }

    public void sendPacket(Packet packet) {
        String serialized = new Gson().toJson(packet);
        channel.writeAndFlush(serialized);
    }

    public void shutdown() {
        group.shutdownGracefully();
    }

}
