package com.sicnu.bulb.entity;

/**
 * Created by HY
 * 2019/4/10 23:20
 * <p>
 * 订单产品项 用于订单(Order）表
 */
@SuppressWarnings("unused")
public class ProductItem {

    /**
     * 产品id
     */
    private int productId;

    /**
     * 数量
     */
    private long num;

    /**
     * 单价
     */
    private float univalence;

    public ProductItem() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public float getUnivalence() {
        return univalence;
    }

    public void setUnivalence(float univalence) {
        this.univalence = univalence;
    }
}
