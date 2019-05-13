package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.msg.ProductMsg;
import com.sicnu.bulb.entity.table.Product;
import com.sicnu.bulb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by HY
 * 2019/5/12 21:50
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
     */
    @RequestMapping("/getAllProducts")
    public Msg getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();
            return new ProductMsg(products);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

}
