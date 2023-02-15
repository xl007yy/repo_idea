package com.lagou.dao;

import com.lagou.damian.Menu;
import com.lagou.damian.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    List<Role> findAllRole(Role role);


}
