package com.sicnu.bulb.entity.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sicnu.bulb.entity.Checkable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HY
 * 2019/4/10 21:29
 * <p>
 * 盘存表
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "tb_inventory")
public class Inventory implements Checkable {

    /**
     * id
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 产品id
     * 外键关联Product表
     */
    @Column(nullable = false)
    private int productId;


    /**
     * 实际库存
     */
    @Column(nullable = false)
    private Long realInventory;

    /**
     * 盘存时间
     */
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inventoryTime;

    /**
     * 备注
     */
    private String intro;


    public Inventory() {
    }

    @Override
    public boolean checkInvalid() {
        return productId != 0 && realInventory != null && inventoryTime != null;
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

    public long getRealInventory() {
        return realInventory;
    }

    public void setRealInventory(long realInventory) {
        this.realInventory = realInventory;
    }

    public Date getInventoryTime() {
        return inventoryTime;
    }

    public void setInventoryTime(Date inventoryTime) {
        this.inventoryTime = inventoryTime;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
