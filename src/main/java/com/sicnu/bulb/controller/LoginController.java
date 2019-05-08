package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.LoginMsg;
import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.ResultCode;
import com.sicnu.bulb.entity.table.Admin;
import com.sicnu.bulb.repository.AdminRepository;
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


/**
 * Created by HY
 * 2019/4/11 9:23
 * <p>
 * 登录相关
 */
@RestController
public class LoginController {

    private final AdminRepository adminRepository;

    @Autowired
    public LoginController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return Msg
     */
    @PostMapping("/login")
    public Msg Login(@RequestParam("username") String username,
                     @RequestParam("password") String password) {
        /*
          使用Shiro编写认证操作
         */
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
            //登录失败
            return new Msg(ResultCode.RESULT_CODE_USER_NOT_EXIST);
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            //密码错误
            return new Msg(ResultCode.RESULT_CODE_ERROR_PASSWORD);
        }
        Admin admin = (Admin) subject.getPrincipals().getPrimaryPrincipal();
        return new LoginMsg(admin.getRoleList().get(0).getRoleId());
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public Msg logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Msg("退出登录成功");
    }

}
