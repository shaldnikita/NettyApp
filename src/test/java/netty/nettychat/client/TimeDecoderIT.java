/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netty.nettychat.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shaldnikita
 */
public class TimeDecoderIT {
    
    public TimeDecoderIT() {
    }

    /**
     * Test of decode method, of class TimeDecoder.
     */
    @Test
    public void testDecode() {
       List<Object> a = new ArrayList<>();
       a.add("asd");
       
        System.out.println(a.get(0).getClass());
    }
    
}
