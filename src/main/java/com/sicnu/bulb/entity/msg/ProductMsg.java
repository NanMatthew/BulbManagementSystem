package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.table.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HY
 * 2019/5/12 21:53
 */
@SuppressWarnings("unused")
public class ProductMsg extends Msg {

    private List<mProduct> products;

    public ProductMsg(List<Product> productList) {
        super(ResultCode.RESULT_CODE_CORRECT);
        products = new ArrayList<>();
        for (Product product : productList) {
            //第一次
            if (products.size() == 0) {
                products.add(new mProduct(product));
                continue;
            }

            //当前最后一个大类
            mProduct mProduct = products.get(products.size() - 1);
            //是否是此大类
            if (mProduct.name.equals(product.getName())) {
                mProduct.add(product);
            } else {
                products.add(new mProduct(product));
            }
        }
    }

    public List<mProduct> getProducts() {
        return products;
    }

    public void setProducts(List<mProduct> products) {
        this.products = products;
    }

    /**
     * 内部类
     * 集合同一种类型但规格不同的产品
     * 对应上述 @{@link #ProductMsg(List)} 注释中的 大类
     * <p>
     * 如 灯泡 15W 和 灯泡45W
     * 则{@code name}为灯泡，{@code productList}为具体产品集合
     */
    private class mProduct {

        //名称
        private String name;

        //单位
        private String unit;

        private List<Product> productList;

        mProduct(Product product) {
            this.name = product.getName();
            this.unit = product.getUnit();
            productList = new ArrayList<>();
            add(product);
        }

        /**
         * 添加产品
         */
        public void add(Product product) {
            productList.add(product);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Product> getProductList() {
            return productList;
        }

        public void setProductList(List<Product> productList) {
            this.productList = productList;
        }
    }
}
