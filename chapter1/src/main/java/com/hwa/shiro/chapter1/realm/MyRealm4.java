package com.hwa.shiro.chapter1.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by LiuHua on 2018/5/6
 */
public class MyRealm4 implements Realm {
    @Override
    public String getName() {
        return "myrealm4";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持USERnamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();//得到用户名
        String password = new String((char[]) token.getCredentials());//得到密码
        if (!"tom".equals(username)){
            throw new UnknownAccountException();//如果用户名错误
        }
        if (!"123".equals(password)){
            throw new IncorrectCredentialsException();//如果密码错误
        }
        //如果身份验证成功，返回一个AutheniticationInfo实现；
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
