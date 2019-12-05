package com.aaa.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.aaa.realm.CustomRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:44
 */
@Configuration
public class ShiroConfig {
    /**
     * 权限管理
     *
     * shiro内置过滤器:拦截用户的请求
     * 1, anon: 匿名拦截器，不需要登录也可以访问，index,login
     * 2，authc：需要用户认证通过后才可以访问。
     * 3，roles：角色拦截器，用户需要拥有指定的角色才可以访问、
     * 4，perms:权限授权拦截器，需要用户拥有指定的权限才可以访问
     * 5.logout：退出拦截器
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        Map<String,String> filterMap = new LinkedHashMap<>();
        //匿名登录,查询全部不需要登录
        filterMap.put("/book/getBookInfo","anon");
        //用户登录不需要登录
        filterMap.put("/user/toLogin","anon");

        filterMap.put("/user/logout","logout");
        //需要认证才能访问
        filterMap.put("/book/*","authc");

        //拦截器链
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        shiroFilterFactoryBean.setLoginUrl("/user/toLogin");


        return shiroFilterFactoryBean;
    }

    /**
     * SecurityManager:认证，授权，加密，session管理
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(CustomRealm customRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(customRealm);
        return defaultWebSecurityManager;
    }
    @Bean
    public CustomRealm getCustomRealm(HashedCredentialsMatcher hashedCredentialsMatcher){
        CustomRealm customRealm = new CustomRealm();
        customRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return customRealm;
    }
    /**
     * 密码加密
     * @return
     */
    @Bean
    public HashedCredentialsMatcher getHashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-256");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     * 没有权限会消失
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect(){

        return new ShiroDialect();
    }
}
