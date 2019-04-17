package com.sicnu.bulb.repository;

import com.sicnu.bulb.entity.table.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by HY
 * 2019/4/11 9:22
 */
public interface AdminRepository extends JpaRepository<Admin,String> {

    @Query
    Admin findByUsername(String username);

}
