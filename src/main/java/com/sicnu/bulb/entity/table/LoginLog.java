package com.sicnu.bulb.entity.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HY
 * 2019/5/14 11:15
 * <p>
 * 登录日志
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "tb_login_log")
public class LoginLog {

    /**
     * id
     * <p>
     * 自增序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 操作类型
     * 登录/退出登录
     */
    private int operationType;

    private String loginIp;

    private String username;

    private String adminName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    private String intro;

    public LoginLog() {
        this.loginTime = new Date();
    }

    public LoginLog(String loginIp, Admin admin) {
        this.loginIp = loginIp;
        this.username = admin.getUsername();
        this.adminName = admin.getName();
        this.loginTime = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
