package com.sicnu.bulb.entity.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public Admin() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
