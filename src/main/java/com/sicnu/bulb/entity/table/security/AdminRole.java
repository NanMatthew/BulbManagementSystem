package com.sicnu.bulb.entity.table.security;

import javax.persistence.*;

/**
 * Created by HY
 * 2019/4/10 22:04
 * <p>
 * 管理员-角色表
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "tb_admin_role")
public class AdminRole {

    /**
     * id
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 管理员Id
     */
    @Column(nullable = false,length = 9)
    private String adminId;

    /**
     * 角色id
     */
    @Column(nullable = false)
    private int roleId;

    /**
     * 备注
     */
    private String intro;

    public AdminRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
