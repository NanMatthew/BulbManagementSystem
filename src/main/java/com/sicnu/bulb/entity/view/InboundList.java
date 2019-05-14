package com.sicnu.bulb.entity.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by HY
 * 2019/5/13 17:00
 * <p>
 * 入库流水账 视图
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "v_inbound_list")
public class InboundList {

    @Id
    private int id;

    /**
     * 产品id
     */
    private int productId;

    private String productName;

    /**
     * 产品单位(只）
     */
    private String productUnit;

    /**
     * 产品规格
     */
    private String productScale;

    /**
     * 入库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inboundTime;

    /**
     * 入库数量
     */
    private long count;

    /**
     * 生产车间
     */
    private String workshop;

    /**
     * 负责人
     */
    private String principal;

    public InboundList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public Date getInboundTime() {
        return inboundTime;
    }

    public void setInboundTime(Date inboundTime) {
        this.inboundTime = inboundTime;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
