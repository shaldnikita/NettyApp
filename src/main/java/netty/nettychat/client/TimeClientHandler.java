/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netty.nettychat.client;

import io.netty.channel.*;
import pojo.Message;

/**
 *
 * @author shaldnikita
 */
public class TimeClientHandler extends SimpleChannelInboundHandler<Message> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        System.out.println("got msg");
        System.out.println(msg);
        ctx.close();
    }
}
