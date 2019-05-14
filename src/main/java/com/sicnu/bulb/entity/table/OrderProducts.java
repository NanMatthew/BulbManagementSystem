package com.sicnu.bulb.entity.table;

import javax.persistence.*;

/**
 * Created by HY
 * 2019/5/13 19:08
 */
@SuppressWarnings("unused")
//@Entity
//@Table(name = "tb_order_products")
public class OrderProducts {

    /**
     * id
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单id
     */
    private int orderId;

    /**
     * 批发还是零售
     * <p>
     * 0为批发 1为零售
     */
    @Column(nullable = false)
    private int orderType;

    /**
     * 产品id
     */
    private int productId;

    /**
     * 订单数量
     */
    private long count;

    /**
     * 备注
     */
    private String intro;

    public OrderProducts() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
