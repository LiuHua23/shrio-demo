package com.hwa.shiro.chapter1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.apache.shiro.realm.text.*;

import java.nio.file.Path;
//import org.junit.jupiter.api.Test;



public class LoginLogoutTest {

    @Test
    public void testLoginLogout() {

        //1.获取SecurityManager工厂，吃出使用ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("C:\\workspace\\shiro-demo\\chapter1\\src\\main\\resources\\shiro.ini");
        //2.得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3.得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("tom","1234");

        try {
            //4.登陆，即身份验证
            subject.login(token);
            System.out.println("验证成功");
        } catch (AuthenticationException e) {
            //5.身份验证失败
            System.out.println("验证失败");
        }

        Assert.assertEquals(true,subject.isAuthenticated());//断言用户已经登录

        //6.推出
        subject.logout();

    }
}
