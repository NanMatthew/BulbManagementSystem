package com.sicnu.bulb.entity.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HY
 * 2019/4/11 8:48
 * <p>
 * 出库视图（订单表+出库表）
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "v_outbound")
public class Outbound {

    /**
     * 出库id
     * <p>
     */
    @Id
    private int outboundId;

    /**
     * 订单id
     */
    private int orderId;

    /**
     * 产品列表
     */
    private String productList;

    /**
     * 订单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderTime;

    /**
     * 出库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date outboundTime;

    /**
     * 仓库
     */
    private String warehouse;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 出库类型（零售/成批）
     */
    private int outboundType;


    /**
     * 下订单的厂商
     */
    private String customer;

    /**
     * 订单备注
     */
    private String orderIntro;

    /**
     * 出库备注
     */
    private String outboundIntro;

    public Outbound() {
    }

    public int getOutboundId() {
        return outboundId;
    }

    public void setOutboundId(int outboundId) {
        this.outboundId = outboundId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

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

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public int getOutboundType() {
        return outboundType;
    }

    public void setOutboundType(int outboundType) {
        this.outboundType = outboundType;
    }

    public String getOrderIntro() {
        return orderIntro;
    }

    public void setOrderIntro(String orderIntro) {
        this.orderIntro = orderIntro;
    }

    public String getOutboundIntro() {
        return outboundIntro;
    }

    public void setOutboundIntro(String outboundIntro) {
        this.outboundIntro = outboundIntro;
    }
}
