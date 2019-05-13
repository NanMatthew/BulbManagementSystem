package com.sicnu.bulb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sicnu.bulb.entity.table.OrderProducts;
import com.sicnu.bulb.entity.table.Product;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HY
 * 2019/5/13 19:52
 * <p>
 * 对应一个订单
 */
@SuppressWarnings("unused")
public class Order {

    //订单id
    private int id;

    //商品列表
    private List<ProductItem> products;

    //订单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    //厂商
    private String customer;

    //备注
    private String intro;

    public Order(com.sicnu.bulb.entity.table.Order order) {
        this.id = order.getId();
        this.orderTime = order.getOrderTime();
        this.customer = order.getCustomer();
        this.intro = order.getIntro();
        this.products = new ArrayList<>();
        List<Product> productList = order.getProductList();
        List<OrderProducts> orderProducts = order.getOrderProducts();
        for (int i = 0; i < productList.size(); i++) {
            OrderProducts orderProducts1 = orderProducts.get(i);
            products.add(new ProductItem(
                    productList.get(i),
                    orderProducts1.getCount(), orderProducts1.getOrderType()));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductItem> getProducts() {
        return products;
    }

    public void setProducts(List<ProductItem> products) {
        this.products = products;
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
