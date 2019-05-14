package com.sicnu.bulb.repository;

import com.sicnu.bulb.entity.table.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by HY
 * 2019/4/10 19:45
 * <p>
 * 对应库存表
 */
public interface StockRepository extends JpaRepository<Stock, Integer> {

    Stock findByProductId(int productId);

    /**
     * 更新产品库存
     *
     * @param productId 产品id
     * @param num       更新数量
     * @return 影响行数
     */
    @Modifying
    @Transactional
    @Query(value = "update tb_stock set  stock = stock + :num where product_id = :productId", nativeQuery = true)
    int updateStock(@Param("productId") int productId,
                    @Param("num") long num);

}
