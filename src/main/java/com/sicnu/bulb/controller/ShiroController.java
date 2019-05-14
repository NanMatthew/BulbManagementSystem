package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HY
 * 2019/4/17 20:12
 * <p>
 * 自定义Shiro拦截请求时返回的{@link Msg}
 *
 * @see Msg
 */
@RestController
public class ShiroController {

    /**
     * 未登录就请求其他url
     *
     * @return {@link Msg}
     */
    @RequestMapping("/needLogin")
    public Msg needLogin() {
        return new Msg(ResultCode.RESULT_CODE_NEED_LOGIN);
    }

    /**
     * 未授权
     *
     * @return {@link Msg}
     */
    @RequestMapping("/noAuth")
    public Msg noAuth() {
        return new Msg(ResultCode.RESULT_CODE_NO_PERMISSION);
    }

}
