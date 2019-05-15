package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.table.Inventory;
import com.sicnu.bulb.repository.InventoryRepository;
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

    @Autowired
    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    /**
     * 盘存
     *
     * @param inventory {@link Inventory}
     */
    @RequestMapping("/inventory")
    public Msg inventory(Inventory inventory) {
        try {
            inventoryRepository.save(inventory);
            return new Msg("盘存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

}
