package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.table.Stock;

import java.util.List;

/**
 * Created by HY
 * 2019/5/14 9:31
 */
@SuppressWarnings("unused")
public class StockListMsg extends Msg {

    private List<Stock> stocks;

    public StockListMsg(List<Stock> stocks) {
        super("所有产品的库存");
        this.stocks = stocks;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
