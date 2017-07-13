package netty.nettychat.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.nio.charset.Charset;
import java.util.List;
import pojo.Message;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shaldnikita
 */
public class MessageDecoder extends ReplayingDecoder<State> {

    private int length;
    private long date;

    public MessageDecoder() {
        super(State.READ_INT);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
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
    }
}

enum State {
    READ_INT,
    READ_LENGTH,
    READ_CONTENT;
}
