package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.OutboundListMsg;
import com.sicnu.bulb.repository.OutboundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by HY
 * 2019/5/13 21:26
 * <p>
 * 出库相关操作
 */
@RestController
public class OutboundController {

    private final OutboundRepository outboundRepository;

    @Autowired
    public OutboundController(OutboundRepository outboundRepository) {
        this.outboundRepository = outboundRepository;
    }

    /**
     * 获取出库单列表
     *
     * @return {@link Msg}
     */
    @GetMapping("/getOutboundList")
    public Msg getOutboundList() {
        try {
            return new OutboundListMsg(outboundRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

}
