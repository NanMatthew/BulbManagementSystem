package com.sicnu.bulb.repository;

import com.sicnu.bulb.entity.table.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HY
 * 2019/5/12 21:49
 */
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
