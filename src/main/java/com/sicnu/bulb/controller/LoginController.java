package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.table.LoginLog;
import com.sicnu.bulb.entity.msg.LoginMsg;
import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.ResultCode;
import com.sicnu.bulb.entity.table.Admin;
import com.sicnu.bulb.repository.LoginLogRepository;
import com.sicnu.bulb.util.GsonUtil;
import com.sicnu.bulb.util.IpUtil;
import com.sicnu.bulb.util.LoggerUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by HY
 * 2019/4/11 9:23
 * <p>
 * 登录相关
 */
@RestController
public class LoginController {

    //登录操作
    private static final int LOGIN_TYPE = 0;
    //退出登录操作
    private static final int LOGOUT_TYPE = 1;

    private final LoginLogRepository loginLogRepository;

    @Autowired
    public LoginController(LoginLogRepository loginLogRepository) {
        this.loginLogRepository = loginLogRepository;
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link Msg}
     */
    @PostMapping("/login")
    public Msg Login(@RequestParam("username") String username,
                     @RequestParam("password") String password, HttpServletRequest servletRequest) {

        // 使用Shiro编写认证操作
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        //3.执行登录方法
        try {
            //将跳转到UserRealm中去
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            //用户名不存在
            return new Msg(ResultCode.RESULT_CODE_USER_NOT_EXIST);
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            //密码错误
            return new Msg(ResultCode.RESULT_CODE_ERROR_PASSWORD);
        }
        Admin admin = (Admin) subject.getPrincipals().getPrimaryPrincipal();

        doLog(admin, IpUtil.getIpAddress(servletRequest), LOGIN_TYPE);
        return new LoginMsg(admin.getRoleList().get(0).getRoleId());
    }

    /**
     * 退出登录
     *
     * @return {@link Msg}
     */
    @RequestMapping("/logout")
    public Msg logout(HttpServletRequest servletRequest) {
        Subject subject = SecurityUtils.getSubject();
        Admin admin = (Admin) subject.getPrincipals().getPrimaryPrincipal();
        doLog(admin, IpUtil.getIpAddress(servletRequest), LOGOUT_TYPE);
        subject.logout();
        return new Msg("退出登录成功");
    }

    //写入日志文件
    private void doLog(Admin admin, String ip, int operationType) {

        LoginLog log = new LoginLog(ip, admin);
        log.setOperationType(operationType);
        if (operationType == LOGIN_TYPE) {
            log.setIntro("登录操作");
        } else {
            log.setIntro("退出登录操作");
        }
//        System.out.println("LoginLog=====" + GsonUtil.getInstance().toJson(log));
        LoggerUtil.getLoginLogger().info(GsonUtil.getInstance().toJson(log));
        loginLogRepository.save(log);
    }

}
