package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.LoginLog;
import com.sicnu.bulb.entity.table.Admin;
import com.sicnu.bulb.entity.table.Order;
import com.sicnu.bulb.entity.table.Outbound;
import com.sicnu.bulb.entity.table.Stock;
import com.sicnu.bulb.entity.table.security.Permission;
import com.sicnu.bulb.entity.view.InboundList;
import com.sicnu.bulb.selflog.OperationLog;
import com.sicnu.bulb.repository.InboundListRepository;
import com.sicnu.bulb.repository.OrderRepository;
import com.sicnu.bulb.repository.OutboundRepository;
import com.sicnu.bulb.repository.StockRepository;
import com.sicnu.bulb.util.GsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HY
 * 2019/4/3 22:01
 * <p>
 * 测试接口
 */
@RestController
public class TestController {

    private final StockRepository stockRepository;
    private final InboundListRepository inboundListRepository;
    private final OutboundRepository outboundRepository;

    @Autowired
    public TestController(StockRepository stockRepository, InboundListRepository inboundListRepository, OutboundRepository outboundRepository) {
        this.stockRepository = stockRepository;
        this.inboundListRepository = inboundListRepository;
        this.outboundRepository = outboundRepository;
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

    @RequestMapping("/test/LoginLog")
    public LoginLog testSelect() {
        LoginLog log = new LoginLog("2", new Admin());
        log.setOperationType(0);
        log.setIntro("登录操作");
        log.setIntro("退出登录操作");
        System.out.println("LoginLog=====" + GsonUtil.getInstance().toJson(log));
        return log;
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

//    @RequestMapping("/test/testOrderList")
//    public List<com.sicnu.bulb.entity.Order> testOrderList() {
//        List<Order> all = orderRepository.findAll();
//        List<com.sicnu.bulb.entity.Order> orderList = new ArrayList<>();
//        for (Order order : all) {
//            orderList.add(new com.sicnu.bulb.entity.Order(order));
//        }
//        return orderList;
//    }

    @OperationLog(description = "测试")
    @RequestMapping("/test/testOutboundList")
    public List<com.sicnu.bulb.entity.Outbound> testOutboundList() {
        List<com.sicnu.bulb.entity.Outbound> outbounds = new ArrayList<>();
        for (Outbound outbound : outboundRepository.findAll()) {
            outbounds.add(new com.sicnu.bulb.entity.Outbound(outbound));
        }
        return outbounds;
    }


}
