/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netty.nettychat.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import pojo.Message;

/**
 *
 * @author shaldnikita
 */
public class TimeEncoder extends MessageToByteEncoder<Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) {

        out.writeInt((int) msg.getDate());
        out.writeInt(msg.getMsg().getBytes().length);
        out.writeBytes(msg.getMsg().getBytes());
        System.out.println("CLIENT ENCODE");
    }
}
