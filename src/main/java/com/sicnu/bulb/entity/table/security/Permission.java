package com.sicnu.bulb.entity.table.security;

import javax.persistence.*;

/**
 * Created by HY
 * 2019/4/10 22:02
 * <p>
 * 权限表
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "tb_permission")
public class Permission {

    /**
     * id
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 备注
     */
    private String intro;

    public Permission() {
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
}
