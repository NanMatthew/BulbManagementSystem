package com.sicnu.bulb.repository;

import com.sicnu.bulb.entity.table.security.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HY
 * 2019/5/13 13:55
 */
public interface AdminRoleRepository extends JpaRepository<AdminRole,Integer> {
}
