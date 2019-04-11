package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.ResultCode;
import com.sicnu.bulb.entity.table.Admin;
import com.sicnu.bulb.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
        try {
            Optional<Admin> optionalAdmin = adminRepository.findById(username);
            if (optionalAdmin.isPresent()) {
                Admin admin = optionalAdmin.get();
                if (password.equals(admin.getPassword())) {
                    return new Msg("登录成功！");
                } else {
                    return new Msg(ResultCode.RESULT_CODE_ERROR_PASSWORD, "密码错误");
                }
            } else {
                return new Msg(ResultCode.RESULT_CODE_USER_NOT_EXIST, "该用户不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

}
