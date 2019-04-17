package com.sicnu.bulb.entity.table.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sicnu.bulb.entity.table.Admin;

import javax.persistence.*;
import java.util.List;

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
     * roleId
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    /**
     * 角色字符串
     * <p>
     * 用于角色控制
     * 不能为空
     */
    @Column(length = 50, nullable = false)
    private String role;

    /**
     * 备注
     */
    private String intro;

    // 用户 - 角色关系定义;
    @ManyToMany
    @JoinTable(name = "tb_admin_role", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "username")})
    private List<Admin> adminList;// 一个角色对应多个用户

    // 角色 - 权限关系定义;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_role_permission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<Permission> permissionList;// 一个角色有多个权限

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @JsonIgnore
    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    @JsonIgnore
    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
