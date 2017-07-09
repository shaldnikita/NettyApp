/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netty.nettychat.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.nio.charset.Charset;
import java.util.List;
import pojo.Message;

/**
 *
 * @author shaldnikita
 */
public class TimeDecoder extends ReplayingDecoder<State> {

    private int length;
    private long date;

    public TimeDecoder() {
        super(State.READ_INT);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)

        switch (state()) {
            case READ_INT:
                date = in.readUnsignedInt();
                checkpoint(State.READ_LENGTH);
            case READ_LENGTH:
                this.length = in.readInt();
                checkpoint(State.READ_CONTENT);
            case READ_CONTENT:
                Message msg = new Message(in.readBytes(length).toString(Charset.defaultCharset()), date);
                out.add(msg);
                checkpoint(State.READ_INT);
                break;
            default:
                throw new Error("Shouldn't reach here.");
        }
        System.out.println("SERVER DECODE");
    }
}

enum State {
    READ_INT,
    READ_LENGTH,
    READ_CONTENT;
}
