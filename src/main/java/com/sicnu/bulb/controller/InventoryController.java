package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.*;
import com.sicnu.bulb.entity.table.Inventory;
import com.sicnu.bulb.repository.InventoryRepository;
import com.sicnu.bulb.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HY
 * 2019/5/15 15:58
 */
@RestController
public class InventoryController {

    private final InventoryRepository inventoryRepository;
    private final StockRepository stockRepository;

    @Autowired
    public InventoryController(InventoryRepository inventoryRepository, StockRepository stockRepository) {
        this.inventoryRepository = inventoryRepository;
        this.stockRepository = stockRepository;
    }

    /**
     * 盘存
     *
     * @param inventory {@link Inventory}
     */
    @RequestMapping("/inventory")
    public Msg inventory(Inventory inventory) {
        try {
            //记录
            Inventory save = inventoryRepository.save(inventory);
            //减少库存量
            stockRepository.updateStock(inventory.getProductId(), -inventory.getLossNum());
            return new InventoryMsg(save);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }


    /**
     * 获取盘存表
     *
     * @return {@link Msg}
     */
    @RequestMapping("/getInventorys")
    public Msg getInventorys() {
        try {
            return new InventoryListMsg(inventoryRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }
}
