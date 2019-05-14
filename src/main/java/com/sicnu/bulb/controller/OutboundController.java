package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.OutboundListMsg;
import com.sicnu.bulb.entity.msg.OutboundMsg;
import com.sicnu.bulb.entity.table.Outbound;
import com.sicnu.bulb.entity.table.Product;
import com.sicnu.bulb.repository.OutboundRepository;
import com.sicnu.bulb.repository.ProductRepository;
import com.sicnu.bulb.repository.StockRepository;
import com.sicnu.bulb.selflog.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * Created by HY
 * 2019/5/13 21:26
 * <p>
 * 出库相关操作
 */
@RestController
public class OutboundController {

    private final OutboundRepository outboundRepository;
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OutboundController(OutboundRepository outboundRepository, StockRepository stockRepository, ProductRepository productRepository) {
        this.outboundRepository = outboundRepository;
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    /**
     * 获取出库单列表
     *
     * @return {@link Msg}
     */
    @OperationLog(description = "获取出库单列表")
    @GetMapping("/getOutboundList")
    public Msg getOutboundList() {
        try {
            return new OutboundListMsg(outboundRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

    /**
     * 填写出库单
     *
     * @return {@link Msg}
     */
    @OperationLog(description = "填写出库单")
    @PostMapping("/addOutbound")
    public Msg addOutbound(Outbound outbound) {
        try {
            if (!outbound.checkInvalid()) {
                return Msg.errorMsg("表单填写有误");
            }
            Outbound save = outboundRepository.save(outbound);
            Optional<Product> byId = productRepository.findById(save.getProductId());
            //noinspection OptionalGetWithoutIsPresent
            save.setProduct(byId.get());
            stockRepository.updateStock(save.getProductId(), -save.getOutboundNum());
            return new OutboundMsg(save);
        } catch (Exception e) {
            return Msg.errorMsg(e.getMessage());
        }
    }

    /**
     * 删除出库单
     *
     * @param outboundId 出库单id
     * @return {@link Msg}
     */
    @OperationLog(description = "删除出库单")
    @DeleteMapping("/deleteOutbound")
    public Msg deleteOutbound(@RequestParam("outboundId") int outboundId) {
        try {
            Optional<Outbound> byId = outboundRepository.findById(outboundId);
            if (!byId.isPresent()) {
                return Msg.errorMsg("该出库单不存在");
            }
            Outbound outbound = byId.get();
            outboundRepository.delete(outbound);
            stockRepository.updateStock(outbound.getProductId(), outbound.getOutboundNum());
            return new Msg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }
}
