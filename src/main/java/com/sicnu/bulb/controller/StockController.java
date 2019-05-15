package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.DangerStock;
import com.sicnu.bulb.entity.msg.DangerStockMsg;
import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.StockListMsg;
import com.sicnu.bulb.entity.msg.StockMsg;
import com.sicnu.bulb.entity.table.Product;
import com.sicnu.bulb.entity.table.Stock;
import com.sicnu.bulb.repository.StockRepository;
import com.sicnu.bulb.selflog.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
     *
     * @return {@link Msg}
     */
    @OperationLog(description = "获取所有商品的库存信息")
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
     *
     * @param productId 产品Id
     * @return {@link Msg}
     */
    @OperationLog(description = "获取产品信息及库存")
    @GetMapping("/getStock")
    public Msg getStockById(@RequestParam("productId") int productId) {
        try {
            return new StockMsg(stockRepository.findByProductId(productId));
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }


    /**
     * 库存警报
     *
     * @return {@link Msg}
     */
    @OperationLog(description = "获取库存警报")
    @GetMapping("/getDangerStock")
    public Msg getDangerStock() {
        try {
            List<DangerStock> dangerStockList = new ArrayList<>();
            List<Stock> all = stockRepository.findAll();
            Product product;
            for (Stock stock : all) {
                product = stock.getProduct();
                if (stock.getStock() > product.getMaxCount()) {
                    dangerStockList.add(new DangerStock(DangerStock.DANGER_TYPE_HIGHER, product));
                } else if (stock.getStock() < product.getMinCount()) {
                    dangerStockList.add(new DangerStock(DangerStock.DANGER_TYPE_LOWER, product));
                }
            }
            return new DangerStockMsg(dangerStockList);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }
}
