package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.damian.Menu;
import com.lagou.damian.MenuVo;
import com.lagou.damian.RoleMenuVO;
import com.lagou.damian.Role_menu_relation;
import com.lagou.dao.MenuMapper;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> findSubMenuListByPid(int id) {
        return menuMapper.findSubMenuListByPid(id);
    }

    @Override
    public List<String> findMenuByRoleId(int roleId) {
        return menuMapper.findMenuByRoleId(roleId);
    }

    @Override
    @Transactional
    public void RoleContextMenu(RoleMenuVO roleMenuVO) {
        int roleId = roleMenuVO.getRoleId();
        menuMapper.deleteRoleMenuRelation(roleId);
        Role_menu_relation role_menu_relation = new Role_menu_relation();
        role_menu_relation.setRoleId(roleId);
        role_menu_relation.setUpdatedby("system");
        role_menu_relation.setCreatedBy("system");
        for (Integer menuId : roleMenuVO.getMenuIdList()) {
            role_menu_relation.setMenuId(menuId);
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            menuMapper.updateRoleMenuRelation(role_menu_relation);
        }
    }

    @Override
    @Transactional
    public void deleteRole(int roleId) {
        menuMapper.deleteRoleMenuRelation(roleId);
        menuMapper.deleteRole(roleId);
    }

    @Override
    public PageInfo<Menu> findAllMenu(MenuVo menuVo) {
        PageHelper.startPage(menuVo.getCurrentPage(),menuVo.getPageSize());
        List<Menu> menuList = menuMapper.findAllMenu();
        PageInfo<Menu> menuPageInfo = new PageInfo<>(menuList);
        return menuPageInfo;
    }

    @Override
    public Menu findMenuById(int id) {
        return menuMapper.findMenuById(id);
    }
}
