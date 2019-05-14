package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.DangerStock;

import java.util.List;

/**
 * Created by HY
 * 2019/5/15 1:47
 */
public class DangerStockMsg extends Msg {

    private List<DangerStock> dangerStocks;

    public DangerStockMsg(List<DangerStock> dangerStocks) {
        super("库存警报列表");
        this.dangerStocks = dangerStocks;
    }

    public List<DangerStock> getDangerStocks() {
        return dangerStocks;
    }

    public void setDangerStocks(List<DangerStock> dangerStocks) {
        this.dangerStocks = dangerStocks;
    }
}
