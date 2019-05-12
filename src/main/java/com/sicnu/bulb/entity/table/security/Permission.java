package com.sicnu.bulb.entity.table.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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
     * permissionId
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;

    /**
     * 权限字符串
     * <p>
     * 用于权限控制
     * 不能为空
     */
    @Column(length = 50, nullable = false)
    private String permission;

    /**
     * 备注
     */
    private String intro;

    // 角色 - 权限关系定义;
    @ManyToMany
    @JoinTable(name = "tb_role_permission", joinColumns = {@JoinColumn(name = "permissionId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList;// 一个角色有多个权限

    public Permission() {
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @JsonIgnore
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", permission='" + permission + '\'' +
                ", intro='" + intro + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
