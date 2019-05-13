package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.view.InboundList;

import java.util.List;

/**
 * Created by HY
 * 2019/5/13 17:14
 */
@SuppressWarnings("unused")
public class InboundListMsg extends Msg {

    private List<InboundList> inboundLists;

    public InboundListMsg(List<InboundList> inboundLists) {
        super("");
        this.inboundLists = inboundLists;
    }

    public List<InboundList> getInboundLists() {
        return inboundLists;
    }

    public void setInboundLists(List<InboundList> inboundLists) {
        this.inboundLists = inboundLists;
    }
}
