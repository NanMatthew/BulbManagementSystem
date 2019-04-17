package com.sicnu.bulb.shiro;

import com.sicnu.bulb.entity.table.Admin;
import com.sicnu.bulb.entity.table.security.Permission;
import com.sicnu.bulb.entity.table.security.Role;
import com.sicnu.bulb.repository.AdminRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by HY
 * 2019/4/17 18:58
 * 自定义Realm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    AdminRepository adminRepository;

    /**
     * 执行授权逻辑
     * 登录时授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");

        //给资源进行授权
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Admin admin = (Admin) principals.getPrimaryPrincipal();
        for (Role role : admin.getRoleList()) {
            //添加角色
            authorizationInfo.addRole(role.getRole());
            for (Permission permission : role.getPermissionList()) {
                //添加权限
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }

        return authorizationInfo;
    }

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Admin admin = adminRepository.findByUsername(token.getUsername());
        if (admin == null) {
            //用户名不存在
            return null;  //UnknownAccountException
        }

        //判断密码
        return new SimpleAuthenticationInfo(admin, admin.getPassword(), "");
    }
}
