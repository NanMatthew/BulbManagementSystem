package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.table.Inbound;

/**
 * Created by HY
 * 2019/5/14 21:14
 */
@SuppressWarnings("unused")
public class InboundMsg extends Msg {

    private Inbound inbound;

    public InboundMsg(Inbound inbound) {
        super("入库单");
        this.inbound = inbound;
    }

    public Inbound getInbound() {
        return inbound;
    }

    public void setInbound(Inbound inbound) {
        this.inbound = inbound;
    }
}
