package com.sicnu.bulb.repository;

import com.sicnu.bulb.entity.table.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HY
 * 2019/4/11 9:22
 */
public interface AdminRepository extends JpaRepository<Admin, String> {

    @Query
    Admin findByUsername(String username);

    @Query
    @Modifying  // 修改/删除操作
    @Transactional
    int deleteByUsername(String username);
}
