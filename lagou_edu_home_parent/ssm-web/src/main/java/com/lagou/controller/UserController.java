package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.damian.ResponseResult;
import com.lagou.damian.User;
import com.lagou.damian.UserVO;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVO userVO) {
        PageInfo<User> user = userService.findAllUserByPage(userVO);
        return new ResponseResult(true, 200, "查询成功", user);
    }

    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User login = userService.login(user);
        if (login != null) {
            // 保存用户id及access_token 到session中
            HttpSession session = request.getSession();
            String access_token = UUID.randomUUID().toString();
            session.setAttribute("access_token",access_token);
            session.setAttribute("user_id",login.getId());


            HashMap<String, Object> map = new HashMap<>();
            map.put("access_token", access_token);
            map.put("user_id", login.getId());

            //将查询的user也存到map中
            map.put("user", login);

            return new ResponseResult(true, 1, "登陆成功", map);


        }
        return new ResponseResult(true, 400, "用户名或密码错误", null);
    }
}
