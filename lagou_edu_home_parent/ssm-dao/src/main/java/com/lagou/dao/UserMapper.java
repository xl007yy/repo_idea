package com.lagou.dao;

import com.lagou.damian.Role;
import com.lagou.damian.User;
import com.lagou.damian.UserVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> findAllUserByPage(UserVO userVO);

    @Select("select * from user where phone = #{phone}")
    User login(User user);


    List<Role> findUserRelationRoleById(Integer id);
}
