package com.sicnu.bulb.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by HY
 * 2019/4/17 18:54
 * <p>
 * Shiro配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     * 用户主体  把操作交给SecurityManager
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加Shiro内置过滤器
        /*
          Shiro内置过滤器，可以实现权限相关的拦截器
             常用的过滤器：
                anon: 无需认证（登录）可以访问
                authc: 必须认证才可以访问
                user: 如果使用rememberMe的功能可以直接访问
                perms： 该资源必须得到资源权限才可以访问
                roles: 该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        //放行
        filterMap.put("/test", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/test/*", "anon");

        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
        filterMap.put("/testSelect", "perms[selectTest]");
        filterMap.put("/testAdd", "perms[addTest]");
        //获取所有产品
        filterMap.put("/getAllProducts", "perms[getAllProducts]");
        //获取入库流水账表
        filterMap.put("/getInboundList", "perms[getInboundList]");
        //获取订单列表
        filterMap.put("/getOrderList", "perms[getOrderList]");
        //管理员的增删改查功能 需要拥有系统管理员角色
        filterMap.put("/admin/*", "roles[sys]");

        //必须认证（登录）
        filterMap.put("/*", "authc");

        //未登录状态访问其他url
        shiroFilterFactoryBean.setLoginUrl("/needLogin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     * 安全管理器 关联Realm
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     * 连接数据的桥梁
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        //        //md5加密
//        HashedCredentialsMatcher md5 = new HashedCredentialsMatcher("MD5");
//        md5.setHashIterations(1024);
//        userRealm.setCredentialsMatcher(md5);
        return new UserRealm();
    }


}
