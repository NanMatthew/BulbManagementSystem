package com.sicnu.bulb.entity.table;


import javax.persistence.*;

/**
 * Created by HY
 * 2019/4/10 17:07
 * <p>
 * 产品表
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "tb_product")
public class Product {

    /**
     * 产品id
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    /**
     * 产品名称
     * <p>
     * 长度20，不能为空
     */
    @Column(length = 20, nullable = false)
    private String name;

    /**
     * 产品单位(只）
     * <p>
     * 长度10，不能为空
     */
    @Column(length = 10, nullable = false)
    private String unit;

    /**
     * 产品规格
     * <p>
     * 长度30，不能为空
     */
    @Column(length = 30, nullable = false)
    private String scale;

    /**
     * 产品成本价
     * <p>
     * 不能为空
     */
    @Column(nullable = false)
    private float cost;

    /**
     * 产品零售单价
     * <p>
     * 不能为空
     */
    @Column(nullable = false)
    private float resale;

    /**
     * 产品批发单价
     * <p>
     * 不能为空
     */
    @Column(nullable = false)
    private float batch;

    /**
     * 产品最大储备量
     * <p>
     * 不能为空
     */
    @Column(nullable = false)
    private long maxCount;

    /**
     * 产品最小储备量
     * <p>
     * 不能为空
     */
    @Column(nullable = false)
    private long minCount;

    /**
     * 备注
     */
    private String intro;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getResale() {
        return resale;
    }

    public void setResale(float resale) {
        this.resale = resale;
    }

    public float getBatch() {
        return batch;
    }

    public void setBatch(float batch) {
        this.batch = batch;
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
