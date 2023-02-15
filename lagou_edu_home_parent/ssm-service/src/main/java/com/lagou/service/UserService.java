package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.damian.User;
import com.lagou.damian.UserVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {

    PageInfo<User> findAllUserByPage(UserVO userVO);

    User login(User user) throws Exception;
}
