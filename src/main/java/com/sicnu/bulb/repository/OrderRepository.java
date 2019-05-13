package com.sicnu.bulb.repository;

import com.sicnu.bulb.entity.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HY
 * 2019/5/13 19:16
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
