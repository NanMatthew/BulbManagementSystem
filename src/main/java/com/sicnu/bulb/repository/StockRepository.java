package com.sicnu.bulb.repository;

import com.sicnu.bulb.entity.table.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HY
 * 2019/4/10 19:45
 * <p>
 * 对应库存表
 */
public interface StockRepository extends JpaRepository<Stock, Integer> {

    Stock findByProductId(int productId);

}
