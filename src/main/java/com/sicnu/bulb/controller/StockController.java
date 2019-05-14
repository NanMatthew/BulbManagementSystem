package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.StockListMsg;
import com.sicnu.bulb.entity.msg.StockMsg;
import com.sicnu.bulb.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HY
 * 2019/5/14 9:28
 * <p>
 * 库存相关
 */
@RestController
public class StockController {

    private final StockRepository stockRepository;

    @Autowired
    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    /**
     * 获取所有商品的库存信息
     */
    @GetMapping("/getStockList")
    public Msg getStockList() {
        try {
            return new StockListMsg(stockRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }


    /**
     * 获取产品信息及库存
     * @param productId 产品Id
     */
    @GetMapping("/getStock")
    public Msg getStockById(@RequestParam("productId") int productId) {
        try {
            return new StockMsg(stockRepository.findByProductId(productId));
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }
}
