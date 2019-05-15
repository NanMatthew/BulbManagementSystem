package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.DangerStock;
import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.table.Outbound;
import com.sicnu.bulb.repository.OutboundRepository;
import com.sicnu.bulb.selflog.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HY
 * 2019/5/15 2:14
 * <p>
 * 财务相关Controller
 */
@RestController
public class FinanceController {

    private final OutboundRepository outboundRepository;

    @Autowired
    public FinanceController(OutboundRepository outboundRepository) {
        this.outboundRepository = outboundRepository;
    }

    /**
     * 根据出库表计算销售额
     *
     * @return {@link Msg}
     */
//    @OperationLog(description = "计算销售额")
//    @GetMapping("/getOutboundFinance")
//    public Msg getOutboundFinance() {
//        try {
//            List<DangerStock> dangerStockList = new ArrayList<>();
//            List<Outbound> all = outboundRepository.findAll();
//            for (Outbound outbound : all) {
//                DangerStock dangerStock = new DangerStock();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Msg.errorMsg(e.getMessage());
//        }
//    }

}
