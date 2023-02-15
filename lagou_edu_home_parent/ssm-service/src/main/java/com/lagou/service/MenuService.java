package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.damian.Menu;
import com.lagou.damian.MenuVo;
import com.lagou.damian.RoleMenuVO;

import java.util.List;

public interface MenuService {

    List<Menu> findSubMenuListByPid(int id);

    List<String> findMenuByRoleId(int roleId);

    void RoleContextMenu(RoleMenuVO roleMenuVO);

    void deleteRole(int roleId);

    PageInfo<Menu> findAllMenu(MenuVo menuVo);

    Menu findMenuById(int id);
}
