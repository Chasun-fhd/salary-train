package aio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * creator: fenghaidong
 * createdAt: 2020/6/27
 * description:
 **/
public class AioServer {

    public static void main(String[] args) {
        EpollEventLoopGroup bossGroup = new EpollEventLoopGroup(1);
        EpollEventLoopGroup workerGroup = new EpollEventLoopGroup(2);

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .option(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new LoggingHandler(LogLevel.DEBUG))
                .childOption(ChannelOption.SO_BACKLOG, 128);

       try {
           ChannelFuture future = bootstrap.bind(9999).sync();
           future.channel().closeFuture().addListener(ret -> {
               System.out.println("Channel closed." + ret);
           });
       } catch ( InterruptedException e) {
           e.printStackTrace();
       } finally {
           bossGroup.shutdownGracefully();
           workerGroup.shutdownGracefully();
       }
    }
}
