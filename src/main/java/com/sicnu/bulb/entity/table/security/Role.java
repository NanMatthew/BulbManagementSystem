package com.sicnu.bulb.entity.table.security;

import javax.persistence.*;

/**
 * Created by HY
 * 2019/4/10 22:00
 * <p>
 * 角色表
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "tb_role")
public class Role {

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

    public Role() {
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
