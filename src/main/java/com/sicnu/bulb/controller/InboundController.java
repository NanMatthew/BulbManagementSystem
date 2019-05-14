package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.InboundListMsg;
import com.sicnu.bulb.entity.msg.InboundMsg;
import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.table.Inbound;
import com.sicnu.bulb.entity.view.InboundList;
import com.sicnu.bulb.repository.InboundListRepository;
import com.sicnu.bulb.repository.InboundRepository;
import com.sicnu.bulb.repository.StockRepository;
import com.sicnu.bulb.selflog.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by HY
 * 2019/5/13 17:15
 * <p>
 * 入库相关操作
 */
@RestController
public class InboundController {


    private final InboundListRepository inboundListRepository;
    private final InboundRepository inboundRepository;
    private final StockRepository stockRepository;

    @Autowired
    public InboundController(InboundListRepository inboundListRepository, InboundRepository inboundRepository, StockRepository stockRepository) {
        this.inboundListRepository = inboundListRepository;
        this.inboundRepository = inboundRepository;
        this.stockRepository = stockRepository;
    }

    /**
     * 获取入库流水账表
     *
     * @return {@link Msg}
     */
    @OperationLog(description = "获取入库流水账表")
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

    /**
     * 填写入库单
     *
     * @return {@link Msg}
     */
    @OperationLog(description = "填写入库单")
    @PostMapping("/addInbound")
    public Msg addInbound(Inbound inbound) {
        try {
            if (!inbound.checkInvalid()) {
                return Msg.errorMsg("表单填写有误");
            }
            Inbound save = inboundRepository.save(inbound);
            stockRepository.updateStock(save.getProductId(), save.getCount());
            return new InboundMsg(save);
        } catch (Exception e) {
            return Msg.errorMsg(e.getMessage());
        }
    }

    @OperationLog(description = "删除入库单")
    @DeleteMapping("/deleteInbound")
    public Msg deleteInbound(@RequestParam("inboundId") int inboundId) {
        try {
            Optional<Inbound> byId = inboundRepository.findById(inboundId);
            if (!byId.isPresent()) {
                return Msg.errorMsg("该入库单不存在");
            }
            Inbound inbound = byId.get();
            inboundRepository.delete(inbound);
            stockRepository.updateStock(inbound.getProductId(), -inbound.getCount());
            return new Msg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

}
