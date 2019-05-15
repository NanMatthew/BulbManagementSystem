package com.sicnu.bulb.entity.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sicnu.bulb.entity.Checkable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HY
 * 2019/4/10 22:13
 * <p>
 * 出库表
 */
@SuppressWarnings("unused")
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "tb_outbound")
public class Outbound implements Checkable {

    /**
     * id
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 厂商
     */
    private String customer;

    private int productId;

    @OneToOne
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    private Product product;

    //出库类型 0为零售 1为批发
    private int outboundType;

    /**
     * 出库数量
     */
    private long outboundNum;

//    /**
//     * 订单id
//     */
//    @Column(nullable = false)
//    private int orderId;

    //insertable=false,updatable=false  要求要加
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "orderId", insertable = false, updatable = false)
//    private Order order;

    /**
     * 出库时间
     */
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date outboundTime;

    /**
     * 仓库
     */
    @Column(nullable = false, length = 20)
    private String warehouse;

    /**
     * 负责人
     */
    @Column(nullable = false, length = 20)
    private String principal;


    /**
     * 备注
     */
    private String intro;

    public Outbound() {

    }

    @Override
    public boolean checkInvalid() {
        return productId != 0 && outboundNum != 0 && outboundTime != null
                && customer != null && warehouse != null && principal != null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOutboundType() {
        return outboundType;
    }

    public void setOutboundType(int outboundType) {
        this.outboundType = outboundType;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getOutboundNum() {
        return outboundNum;
    }

    public void setOutboundNum(long outboundNum) {
        this.outboundNum = outboundNum;
    }

    //    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }

    public Date getOutboundTime() {
        return outboundTime;
    }

    public void setOutboundTime(Date outboundTime) {
        this.outboundTime = outboundTime;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
