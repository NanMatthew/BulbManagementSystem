package com.sicnu.bulb.controller;

import com.alibaba.druid.filter.config.ConfigTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HY
 * 2019/4/3 22:01
 */
@RestController
public class TestController {

    private static final String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALF2PdYVbAnn98jxMWXWyFnMkCSc0ySF0/ll+i7cS5nENis9cbHWtOGn+Hb6+7c2h6PYZrjwOkFKC5F/veMAJBUCAwEAAQ==";
    private static final String password = "SQpw1ssKN9HTvIZSxkLYvcDS1IQ6u0a+8uLHItBJ7Vyun6PUhjPuM3iOH6YrPGJQjtZH1HaIbFofxMuuN8OkJQ==";


    @RequestMapping("/test")
    public String test() {
        String s = null;

//        try {
//            String decrypt = ConfigTools.decrypt(publicKey, password);
//            System.out.println("password="+decrypt);
//            s = decrypt;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println();
        return s;
    }

}
