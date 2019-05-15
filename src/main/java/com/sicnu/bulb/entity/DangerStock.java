package com.sicnu.bulb.entity;

import com.sicnu.bulb.entity.table.Product;

/**
 * Created by HY
 * 2019/5/15 1:42
 * <p>
 * 库存警报
 */
@SuppressWarnings("unused")
public class DangerStock {

    /**
     * 超出最大库存警告
     */
    public static final int DANGER_TYPE_HIGHER = 0;

    /**
     * 低于最小库存警告
     */
    public static final int DANGER_TYPE_LOWER = 1;

    private int dangerType;

    private Product product;

    private String info;

    public DangerStock(int dangerType, Product product) {
        this.dangerType = dangerType;
        this.product = product;
        switch (dangerType) {
            case DANGER_TYPE_HIGHER:
                this.info = "超出最大库存限制";
                break;
            case DANGER_TYPE_LOWER:
                this.info = "低于最小库存限制";
                break;
        }
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getDangerType() {
        return dangerType;
    }

    public void setDangerType(int dangerType) {
        this.dangerType = dangerType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
