/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netty.nettychat.client;

import netty.nettychat.codec.MessageEncoder;
import netty.nettychat.codec.MessageDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.Scanner;
import pojo.Message;

/**
 *
 * @author shaldnikita
 */
public class Client {

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int port = 5005;

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new MessageEncoder(), new MessageDecoder(), new TimeClientHandler());
                }
            });

            Channel ch = b.connect(host, port).sync().channel();

            Scanner in = new Scanner(System.in);

            ch.writeAndFlush(new Message("hello"));
            ch.writeAndFlush(new Message("hello again"));
            ch.closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
