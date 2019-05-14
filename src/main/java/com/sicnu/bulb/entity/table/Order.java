package com.sicnu.bulb.entity.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by HY
 * 2019/4/10 21:45
 * <p>
 * 订单表
 */
@SuppressWarnings("unused")
//@Entity
//@Table(name = "tb_order")
public class Order {

    /**
     * id
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToMany(fetch = FetchType.EAGER)  //立即从数据库中加载数据
    @JoinTable(name = "tb_order_products", joinColumns = {@JoinColumn(name = "orderId")}, inverseJoinColumns = {@JoinColumn(name = "productId")})
    private List<Product> productList;

    /**
     * 商品订单列表
     * <p>
     * 一个订单有多件商品
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private List<OrderProducts> orderProducts;

    public List<OrderProducts> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProducts> orderProducts) {
        this.orderProducts = orderProducts;
    }

    /**
     * 订单时间
     */
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    /**
     * 厂商
     */
    @Column(nullable = false, length = 50)
    private String customer;

    /**
     * 备注
     */
    private String intro;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
