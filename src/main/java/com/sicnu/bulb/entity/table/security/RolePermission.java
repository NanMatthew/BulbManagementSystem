package com.sicnu.bulb.entity.table.security;

import javax.persistence.*;

/**
 * Created by HY
 * 2019/4/10 22:04
 * <p>
 * 角色-权限表
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "tb_role_permission")
public class RolePermission {

    /**
     * id
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 角色Id
     */
    @Column(nullable = false)
    private int roleId;

    /**
     * 权限id
     */
    @Column(nullable = false)
    private int permissionId;

    /**
     * 备注
     */
    private String intro;

    public RolePermission() {
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

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
