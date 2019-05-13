package com.sicnu.bulb.entity;


import com.sicnu.bulb.entity.table.Product;


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
    private long orderNum;

    /**
     * 批发还是零售
     * <p>
     * 0为批发 1为零售
     */
    private int orderType;

    /**
     * 产品名称
     * <p>
     * 长度20，不能为空
     */
    private String productName;

    /**
     * 产品单位(只）
     * <p>
     * 长度10，不能为空
     */
    private String productUnit;

    /**
     * 产品规格
     * <p>
     * 长度30，不能为空
     */
    private String productScale;

    /**
     * 产品成本价
     * <p>
     * 不能为空
     */
    private float productCost;

    /**
     * 产品零售单价
     * <p>
     * 不能为空
     */
    private float productResale;

    /**
     * 产品批发单价
     * <p>
     * 不能为空
     */
    private float productBatch;

    /**
     * 产品最大储备量
     * <p>
     * 不能为空
     */
    private long maxCount;

    /**
     * 产品最小储备量
     * <p>
     * 不能为空
     */
    private long minCount;

    /**
     * 备注
     */
    private String intro;

    public ProductItem() {
    }

    ProductItem(Product product, long orderNum, int orderType) {
        this.productId = product.getId();
        this.productName = product.getName();
        this.productUnit = product.getUnit();
        this.productScale = product.getScale();
        this.productCost = product.getCost();
        this.productBatch = product.getBatch();
        this.productResale = product.getResale();
        this.maxCount = product.getMaxCount();
        this.minCount = product.getMinCount();
        this.intro = product.getIntro();
        this.orderNum = orderNum;
        this.orderType = orderType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(long orderNum) {
        this.orderNum = orderNum;
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

    public float getProductCost() {
        return productCost;
    }

    public void setProductCost(float productCost) {
        this.productCost = productCost;
    }

    public float getProductResale() {
        return productResale;
    }

    public void setProductResale(float productResale) {
        this.productResale = productResale;
    }

    public float getProductBatch() {
        return productBatch;
    }

    public void setProductBatch(float productBatch) {
        this.productBatch = productBatch;
    }

    public long getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(long maxCount) {
        this.maxCount = maxCount;
    }

    public long getMinCount() {
        return minCount;
    }

    public void setMinCount(long minCount) {
        this.minCount = minCount;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
