package com.sicnu.bulb.repository;

import com.sicnu.bulb.entity.table.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HY
 * 2019/5/15 15:55
 */
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
}
