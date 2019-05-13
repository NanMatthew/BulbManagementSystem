package com.sicnu.bulb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by HY
 * 2019/5/13 21:19
 * <p>
 * 对应一个出库单
 */
@SuppressWarnings("unused")
public class Outbound {

    //出库单id
    private int id;

    //订单id
    private int orderId;

    /**
     * 出库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date outboundTime;

    /**
     * 对应的订单信息
     */
    private Order order;

    /**
     * 仓库
     */
    private String warehouse;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 备注
     */
    private String intro;


    public Outbound(com.sicnu.bulb.entity.table.Outbound outbound) {
        this.id = outbound.getId();
        this.orderId = outbound.getOrderId();
        this.outboundTime = outbound.getOutboundTime();
        this.principal = outbound.getPrincipal();
        this.intro = outbound.getIntro();
        this.warehouse = outbound.getWarehouse();
        this.order = new Order(outbound.getOrder());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOutboundTime() {
        return outboundTime;
    }

    public void setOutboundTime(Date outboundTime) {
        this.outboundTime = outboundTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
