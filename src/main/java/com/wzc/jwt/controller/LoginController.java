package com.wzc.jwt.controller;

import com.wzc.jwt.model.HttpResult;
import com.wzc.jwt.model.LoginData;
import com.wzc.jwt.utils.JwtUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: joey
 * Date: 2019-03-29 16:06
 */
@RestController
public class LoginController {

    @Autowired
    private JwtUtils jwtUtils;

    @Value("${wzc.login.username}")
    private String username;
    @Value("${wzc.login.password}")
    private String password;


    @PostMapping("doLogin")
    public HttpResult login(@RequestBody LoginData loginData){

        if (StringUtils.isEmpty(loginData.getUsername()) || StringUtils.isEmpty(loginData.getPassword()))
            return HttpResult.error("用户名或密码不能为空！！");
        if (!username.equals(loginData.getUsername()) || !password.equals(loginData.getPassword()))
            return HttpResult.error("用户名或密码错误！");

        //生成token
        String token = jwtUtils.generateToken(1);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        return HttpResult.ok(map);
    }

}
