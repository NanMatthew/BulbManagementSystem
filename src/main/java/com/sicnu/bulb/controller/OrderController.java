package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.OrderListMsg;
import com.sicnu.bulb.entity.table.Order;
import com.sicnu.bulb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by HY
 * 2019/5/13 20:08
 * <p>
 * 订单相关操作
 */
@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * 获取订单列表
     *
     * @return {@link Msg}
     */
    @GetMapping("/getOrderList")
    public Msg getOrderList() {
        try {
            List<Order> all = orderRepository.findAll();
            return new OrderListMsg(all);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

}
