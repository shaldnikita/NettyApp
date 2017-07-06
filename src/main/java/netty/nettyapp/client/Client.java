/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netty.nettyapp.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 *
 * @author shaldnikita
 */
public class Client {

    public static void main(String[] args) throws Exception{

        String host = "localhost";
        int port = 5005;
        
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        try{
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeDecoder(),new TimeClientHandler()); //To change body of generated methods, choose Tools | Templates.
                }
            });
            
            ChannelFuture f = b.connect(host, port).sync();
            
            f.channel().closeFuture().sync();
        } finally{
            workerGroup.shutdownGracefully();
        }
    }
}
