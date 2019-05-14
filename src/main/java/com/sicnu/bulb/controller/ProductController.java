package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.ProductMsg;
import com.sicnu.bulb.entity.msg.ProductsMsg;
import com.sicnu.bulb.entity.msg.ResultCode;
import com.sicnu.bulb.entity.table.Product;
import com.sicnu.bulb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by HY
 * 2019/5/12 21:50
 * <p>
 * 产品相关操作
 */
@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 获取所有产品列表
     *
     * @return {@link Msg}
     */
    @RequestMapping("/getAllProducts")
    public Msg getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();
            return new ProductsMsg(products);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

    /**
     * 获取单个产品信息
     *
     * @param productId 产品id
     * @return {@link Msg}
     */
    @GetMapping("/getProductInfo")
    public Msg getProductInfo(@RequestParam("productId") int productId) {
        try {
            Optional<Product> byId = productRepository.findById(productId);
            //noinspection OptionalIsPresent
            if (byId.isPresent()) {
                return new ProductMsg(byId.get());
            } else {
                return new Msg(ResultCode.RESULT_CODE_PRODUCT_NOT_EXIST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

}
