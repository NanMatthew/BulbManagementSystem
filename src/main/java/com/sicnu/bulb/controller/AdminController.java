package com.sicnu.bulb.controller;

import com.sicnu.bulb.entity.msg.AdminsMsg;
import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.entity.table.Admin;
import com.sicnu.bulb.entity.table.security.AdminRole;
import com.sicnu.bulb.repository.AdminRepository;
import com.sicnu.bulb.repository.AdminRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by HY
 * 2019/5/13 13:45
 * <p>
 * 对管理员的增删改查等操作
 */
@SuppressWarnings("WeakerAccess")
@RestController
public class AdminController {

    private final AdminRepository adminRepository;
    private final AdminRoleRepository adminRoleRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository, AdminRoleRepository adminRoleRepository) {
        this.adminRepository = adminRepository;
        this.adminRoleRepository = adminRoleRepository;
    }

    /**
     * 获取所有管理员信息
     *
     * @return {@link Msg}
     */
    @GetMapping("/admin/findAll")
    public Msg findAllAdministrator() {
        try {
            List<Admin> all = adminRepository.findAll();
            return new AdminsMsg(all);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }

    /**
     * 添加管理员
     *
     * @param adminType 管理员类型 {@code Admin.ADMIN_TYPE_SYS,Admin.ADMIN_TYPE_FINANCE,Admin.ADMIN_TYPE_WAREHOUSE}
     * @return {@link Msg}
     * @see Admin
     */
    @PostMapping("/admin/add")
    public Msg addAdministrator(Admin admin, @RequestParam("adminType") int adminType) {

        if (admin.checkInvalid()) {
            if (adminRepository.findByUsername(admin.getUsername()) != null) {
                return Msg.errorMsg("该用户已存在！");
            }
            try {
                switch (adminType) {
                    case 1: //系统管理员
                        saveAdmin(admin, Admin.ADMIN_TYPE_SYS, adminType);
                        break;
                    case 2: //财务管理员
                        saveAdmin(admin, Admin.ADMIN_TYPE_FINANCE, adminType);
                        break;
                    case 3: //仓库管理员
                        saveAdmin(admin, Admin.ADMIN_TYPE_WAREHOUSE, adminType);
                        break;
                }
                return new Msg("添加成功");
            } catch (Exception e) {
                e.printStackTrace();
                return Msg.errorMsg(e.getMessage());
            }
        } else {
            return Msg.errorMsg("传过来的admin有误");
        }
    }

    /**
     * 删除管理员
     *
     * @return {@link Msg}
     */
    @DeleteMapping("/admin/delete")
    public Msg deleteAdmin(@RequestParam("username") String username) {
        try {
            if (adminRepository.deleteByUsername(username) == 0) {
                return Msg.errorMsg("该用户不存在");
            }
            return new Msg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
    }


    private void saveAdmin(Admin admin, String info, int adminType) {
        //存储管理员
        admin.setIntro(info);
        adminRepository.save(admin);

        //添加角色
        AdminRole adminRole = new AdminRole(admin.getUsername());
        adminRole.setRoleId(adminType);
        adminRole.setIntro(info);
        adminRoleRepository.save(adminRole);
    }


}
