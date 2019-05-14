package com.sicnu.bulb.entity.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sicnu.bulb.entity.Checkable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HY
 * 2019/4/10 22:13
 * <p>
 * 入库表
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "tb_inbound")
public class Inbound implements Checkable {

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
     */
    @Column(nullable = false)
    private int productId;

    /**
     * 入库时间
     */
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inboundTime;

    /**
     * 入库数量
     */
    @Column(nullable = false)
    private long count;

    /**
     * 生产车间
     */
    @Column(nullable = false, length = 20)
    private String workshop;

    /**
     * 负责人
     */
    @Column(nullable = false, length = 20)
    private String principal;

    /**
     * 审核状态
     */
    @Column(length = 20, columnDefinition = "bit(1) default false")
    private boolean checkState;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "tb_product", joinColumns = {@JoinColumn(name = "product_id")}, inverseJoinColumns = {@JoinColumn(name = "id")})
//    private Product product;

    /**
     * 备注
     */
    private String intro;

    public Inbound() {
    }

    @Override
    public boolean checkInvalid() {
        return productId != 0 && inboundTime != null
                && count != 0 && workshop != null && principal != null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public boolean isCheckState() {
        return checkState;
    }

    public void setCheckState(boolean checkState) {
        this.checkState = checkState;
    }
}
