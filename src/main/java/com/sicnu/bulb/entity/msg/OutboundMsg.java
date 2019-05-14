package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.table.Outbound;

/**
 * Created by HY
 * 2019/5/14 21:14
 */
@SuppressWarnings("unused")
public class OutboundMsg extends Msg {

    private Outbound inbound;

    public OutboundMsg(Outbound inbound) {
        super("入库单");
        this.inbound = inbound;
    }

    public Outbound getInbound() {
        return inbound;
    }

    public void setInbound(Outbound inbound) {
        this.inbound = inbound;
    }
}
