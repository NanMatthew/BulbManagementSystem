package com.sicnu.bulb.entity.table;


import javax.persistence.*;

/**
 * Created by HY
 * 2019/4/10 17:24
 * <p>
 * 库存表
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "tb_stock")
public class Stock {

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

    @OneToOne
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    private Product product;

    /**
     * 电子库存
     */
    @Column(nullable = false)
    private long stock;

    /**
     * 备注
     */
    private String intro;

    public Stock() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
