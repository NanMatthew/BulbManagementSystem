package com.sicnu.bulb.entity.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sicnu.bulb.entity.table.security.Role;

import javax.persistence.*;
import java.util.List;

/**
 * Created by HY
 * 2019/4/10 21:51
 * <p>
 * 管理员表
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "tb_admin")
public class Admin {

    public static final String ADMIN_TYPE_SYS = "系统管理员";

    public static final String ADMIN_TYPE_FINANCE = "财务管理员";

    public static final String ADMIN_TYPE_WAREHOUSE = "仓库管理员";

    /**
     * 用户名/工号
     * <p>
     * 长度为9
     * 示例 201904001
     */
    @Id
    @Column(length = 9)
    private String username;

    /**
     * 密码
     */
    @Column(nullable = false, length = 20)
    private String password;

    /**
     * 姓名
     */
    @Column(nullable = false, length = 20)
    private String name;

    /**
     * 电话号码
     */
    @Column(nullable = false, length = 20)
    private String phoneNumber;

    /**
     * 备注
     */
    private String intro;

    /**
     * 角色列表
     * <p>
     * 一个用户可以有多个角色
     */
    @ManyToMany(fetch = FetchType.EAGER)  //立即从数据库中加载数据
    @JoinTable(name = "tb_admin_role", joinColumns = {@JoinColumn(name = "username")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList;

    public Admin() {
    }

    public Admin(String username, String password, String name, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * 对象是否合法
     * <p>
     * 针对AdminController传入的admin对象
     */
    public boolean checkInvalid() {
        return username != null && password != null
                && name != null && phoneNumber != null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
