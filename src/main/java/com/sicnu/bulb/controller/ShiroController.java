package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HY
 * 2019/4/17 20:12
 */
@RestController
public class ShiroController {

    /**
     * 未登录就请求其他url
     */
    @RequestMapping("/needLogin")
    public Msg needLogin() {
        return new Msg(ResultCode.RESULT_CODE_NEED_LOGIN);
    }

    /**
     * 未授权
     */
    @RequestMapping("/noAuth")
    public Msg noAuth() {
        return new Msg(ResultCode.RESULT_CODE_NO_PERMISSION);
    }

}
