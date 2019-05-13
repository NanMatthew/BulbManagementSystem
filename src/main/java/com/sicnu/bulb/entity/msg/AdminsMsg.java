package com.sicnu.bulb.entity.msg;

import com.sicnu.bulb.entity.table.Admin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HY
 * 2019/5/13 15:21
 */
@SuppressWarnings("unused")
public class AdminsMsg extends Msg {

    private List<Admin2> adminList;

    public AdminsMsg(List<Admin> adminList) {
        super("");
        this.adminList = new ArrayList<>();
        for (Admin admin : adminList) {
            this.adminList.add(new Admin2(admin));
        }
    }

    public List<Admin2> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin2> adminList) {
        this.adminList = adminList;
    }

    class Admin2 {
        private String username;

        //管理员类型
        private int adminType;

        /**
         * 姓名
         */
        private String name;

        /**
         * 电话号码
         */
        private String phoneNumber;

        /**
         * 备注
         */
        private String intro;

        Admin2(Admin admin) {
            this.username = admin.getUsername();
            this.name = admin.getName();
            this.phoneNumber = admin.getPhoneNumber();
            this.intro = admin.getIntro();

            switch (intro) {
                case Admin.ADMIN_TYPE_SYS:
                    this.adminType = 1;
                    break;
                case Admin.ADMIN_TYPE_FINANCE:
                    this.adminType = 2;
                    break;
                case Admin.ADMIN_TYPE_WAREHOUSE:
                    this.adminType = 3;
                    break;
            }
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getAdminType() {
            return adminType;
        }

        public void setAdminType(int adminType) {
            this.adminType = adminType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }
    }

}
