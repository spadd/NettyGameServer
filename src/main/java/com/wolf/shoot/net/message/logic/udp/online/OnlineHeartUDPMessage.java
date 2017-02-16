package com.wolf.shoot.net.message.logic.udp.online;

import com.wolf.shoot.common.annotation.MessageCommandAnnotation;
import com.wolf.shoot.net.message.MessageCommands;
import com.wolf.shoot.net.message.NetProtoBufMessage;
import com.wolf.shoot.net.message.NetProtoBufUDPMessage;
import com.wolf.shoot.net.message.auto.tcp.online.OnlineTCPProBuf;

/**
 * Created by jwp on 2017/2/16.
 */
@MessageCommandAnnotation(command = MessageCommands.ONLINE_HEART_UDP_MESSAGE)
public class OnlineHeartUDPMessage extends NetProtoBufUDPMessage {

    private int id;

    public  OnlineHeartUDPMessage(){
        setCmd(MessageCommands.ONLINE_HEART_UDP_MESSAGE.command_id);
    }

    @Override
    public void decoderNetProtoBufMessageBody() throws Exception {
        byte[] bytes = getNetMessageBody().getBytes();
        OnlineTCPProBuf.OnlineHeartTCPProBuf req = OnlineTCPProBuf.OnlineHeartTCPProBuf.parseFrom(bytes);
        setId(req.getId());
    }

    @Override
    public void release() {

    }

    @Override
    public void encodeNetProtoBufMessageBody() throws Exception {
        OnlineTCPProBuf.OnlineHeartTCPProBuf.Builder builder = OnlineTCPProBuf.OnlineHeartTCPProBuf.newBuilder();
        builder.setId(getId());
        byte[] bytes = builder.build().toByteArray();
        getNetProtoBufMessageBody().setBytes(bytes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

