package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.InboundListMsg;
import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.view.InboundList;
import com.sicnu.bulb.repository.InboundListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by HY
 * 2019/5/13 17:15
 * <p>
 * 入库相关操作
 */
@RestController
public class InboundController {

    private final InboundListRepository inboundListRepository;

    @Autowired
    public InboundController(InboundListRepository inboundListRepository) {
        this.inboundListRepository = inboundListRepository;
    }

    /**
     * 获取入库流水账表
     *
     * @return {@link Msg}
     */
    @GetMapping("/getInboundList")
    public Msg getInboundList() {
        try {
            List<InboundList> all = inboundListRepository.findAll();
            return new InboundListMsg(all);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

}
