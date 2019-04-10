package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.table.Stock;
import com.sicnu.bulb.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by HY
 * 2019/4/3 22:01
 */
@RestController
public class TestController {

    private final StockRepository stockRepository;

    @Autowired
    public TestController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
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
        return null;
    }


    @RequestMapping("/test/stock/{id}")
    public Stock testStock(@PathVariable int id) {
        return stockRepository.findByProductId(id);
    }
}
