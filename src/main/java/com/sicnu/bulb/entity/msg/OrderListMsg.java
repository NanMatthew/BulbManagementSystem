package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HY
 * 2019/5/13 19:38
 */
@SuppressWarnings("unused")
public class OrderListMsg extends Msg {

    private List<Order> orders;

    public OrderListMsg(List<com.sicnu.bulb.entity.table.Order> orderList) {
        super("订单列表");
        this.orders = new ArrayList<>();
        for (com.sicnu.bulb.entity.table.Order order : orderList) {
            orders.add(new com.sicnu.bulb.entity.Order(order));
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
