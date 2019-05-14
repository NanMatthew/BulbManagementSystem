package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.table.Stock;

/**
 * Created by HY
 * 2019/5/14 9:44
 */
@SuppressWarnings("unused")
public class StockMsg extends Msg {

    private Stock stock;

    public StockMsg(Stock stock) {
        super("产品信息及库存量");
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
