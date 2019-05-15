package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.table.Inventory;

/**
 * Created by HY
 * 2019/5/15 16:51
 *
 * 盘存
 */
@SuppressWarnings("unused")
public class InventoryMsg extends Msg {

    private Inventory inventory;

    public InventoryMsg(Inventory inventory) {
        super("盘存信息");
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
