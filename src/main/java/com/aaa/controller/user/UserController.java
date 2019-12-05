package com.aaa.controller.user;

import com.aaa.model.UserInfo;
import com.aaa.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:29
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public  String login(String userName, String userPass,ModelMap modelMap){
        Subject subject = SecurityUtils.getSubject();

        //判断认证是否通过
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, userPass);

            try {
                subject.login(token);
                return "redirect:/book/getBookInfo";
            }catch (UnknownAccountException uae) {
                modelMap.addAttribute("msg", uae.getMessage());
            } catch (IncorrectCredentialsException ice) {
                modelMap.addAttribute("msg", "密码错误");
                System.out.println("密码错误");

            } catch (LockedAccountException lae) {
                modelMap.addAttribute("msg", lae.getMessage());
                System.out.println("该账户已经锁定");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                /**
                 * AuthenticationException是以上三个异常的父类
                 */
                System.out.println("认证失败");
                //先抛小的，再抛大的
                modelMap.addAttribute("msg", "认证失败");
            }

            return "login";
        }else{
            return "redirect:/book/getBookInfo";
        }

    }

    /**
     * 用户注册
     * @param
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        return "addUser";
    }
    @RequestMapping("/addUser")
    public String addUser(UserInfo userInfo){
        String hashAlgorithmName = "SHA-256";
        String credentials = userInfo.getUserPassword();
        String salt = userInfo.getUserName();
        Integer hashIterations = 1024;
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        String s = simpleHash.toString();
        userInfo.setUserPassword(s);
        userService.addUser(userInfo);
        return  "login";
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }


}
