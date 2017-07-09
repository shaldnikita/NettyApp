/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;

/**
 *
 * @author shaldnikita
 */
public class Message {

    private final String msg;
    private final long date;

    public Message(String msg) {
        this(msg,System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public Message(String msg, long date) {
        this.msg = msg;
        this.date = date;
    }

    
    
    public String getMsg() {
        return msg;
    }

    public long getDate() {
        return date;
    }
    
    @Override
    public String toString() {
        return "["+ new Date((getDate() - 2208988800L) * 1000L).toString()+"]: "+getMsg();
    }

}
