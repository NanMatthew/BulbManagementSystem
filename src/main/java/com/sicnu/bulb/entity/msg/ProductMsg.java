package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.table.Product;

/**
 * Created by HY
 * 2019/5/14 10:06
 */
@SuppressWarnings("unused")
public class ProductMsg extends Msg {

    private Product product;

    public ProductMsg(Product product) {
        super("产品信息");
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
