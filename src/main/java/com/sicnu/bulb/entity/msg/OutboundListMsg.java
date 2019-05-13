package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.Outbound;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HY
 * 2019/5/13 21:28
 */
@SuppressWarnings("unused")
public class OutboundListMsg extends Msg {

    private List<Outbound> outbounds;

    public OutboundListMsg(List<com.sicnu.bulb.entity.table.Outbound> outboundList) {
        super("出库单列表");
        this.outbounds = new ArrayList<>();
        for (com.sicnu.bulb.entity.table.Outbound outbound : outboundList) {
            this.outbounds.add(new Outbound(outbound));
        }
    }

    public List<Outbound> getOutbounds() {
        return outbounds;
    }

    public void setOutbounds(List<Outbound> outbounds) {
        this.outbounds = outbounds;
    }
}
