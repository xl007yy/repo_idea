package com.lagou.dao;

import com.lagou.damian.Menu;
import com.lagou.damian.Role_menu_relation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {

    List<Menu> findSubMenuListByPid(int id);

    List<String> findMenuByRoleId(int roleId);

    @Delete("delete from role_menu_relation where role_id = #{roleId}")
    void deleteRoleMenuRelation(int roleId);

    void updateRoleMenuRelation(Role_menu_relation role_menu_relations);

    @Delete("delete from roles where id = #{roleId}")
    void deleteRole(int roleId);

    @Select("select * from menu")
    List<Menu> findAllMenu();

    @Select(("select * from menu where id = #{id}"))
    Menu findMenuById(int id);
}
