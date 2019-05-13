package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.table.Admin;
import com.sicnu.bulb.entity.table.Stock;
import com.sicnu.bulb.entity.table.security.Permission;
import com.sicnu.bulb.entity.view.InboundList;
import com.sicnu.bulb.repository.InboundListRepository;
import com.sicnu.bulb.repository.StockRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by HY
 * 2019/4/3 22:01
 */
@RestController
public class TestController {

    private final StockRepository stockRepository;
    private final InboundListRepository inboundListRepository;

    @Autowired
    public TestController(StockRepository stockRepository, InboundListRepository inboundListRepository) {
        this.stockRepository = stockRepository;
        this.inboundListRepository = inboundListRepository;
    }

    @RequestMapping("/test")
    public String test() {
        File path;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) path = new File("");
            System.out.println("path:" + path.getAbsolutePath());
            return path.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping("/testSelect")
    public String testSelect() {
        return "testSelect";
    }

    @RequestMapping("/testAdd")
    public String testAdd() {
        return "testAdd";
    }

    @RequestMapping("/test/stock/{id}")
    public Stock testStock(@PathVariable int id) {
        return stockRepository.findByProductId(id);
    }

    @RequestMapping("/test/testPermission")
    public List<Permission> testPermission() {
        Subject subject = SecurityUtils.getSubject();

        Admin admin = (Admin) subject.getPrincipals().getPrimaryPrincipal();
        return admin.getRoleList().get(0).getPermissionList();
    }

    @RequestMapping("/test/testInboundList")
    public List<InboundList> testInboundList() {
        return inboundListRepository.findAll();
    }
}
