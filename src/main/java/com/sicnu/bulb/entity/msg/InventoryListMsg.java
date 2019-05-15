package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.table.Inventory;

import java.util.List;

/**
 * Created by HY
 * 2019/5/15 16:51
 * <p>
 * 盘存
 */
@SuppressWarnings("unused")
public class InventoryListMsg extends Msg {

    private List<Inventory> inventory;

    public InventoryListMsg(List<Inventory> inventory) {
        super("盘存列表");
        this.inventory = inventory;
    }

    public List<Inventory> getInventory() {

        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }
}
