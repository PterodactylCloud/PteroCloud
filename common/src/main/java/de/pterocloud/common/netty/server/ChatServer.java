package de.pterocloud.common.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Provider;
import java.security.Security;

@Slf4j
@AllArgsConstructor
public class ChatServer {

    private int port;

    public void start() throws Exception {


        log.debug("Creating certificate");
        System.out.println("TEST");
        SelfSignedCertificate ssc = new SelfSignedCertificate();
        log.debug("Certificate created");

        log.debug("Creating SSL context");
        System.out.println("TEST");
        SslContext sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
        System.out.println("TEST");
        log.debug("SSL context created");

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new SecureChatServerInitializer(sslCtx));
            log.debug("Try to bind to port: {}", port);
            b.bind(port).sync().channel().closeFuture().sync();
        } finally {
            log.debug("Shutdown server");
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            log.info("Server was shut down successfully");
        }

    }

}