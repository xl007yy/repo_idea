package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.damian.*;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){
        List<Role> roles = roleService.findAllRole(role);
        return new ResponseResult(true, 200, "查询成功", roles);
    }

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> menus = menuService.findSubMenuListByPid(-1);
        return new ResponseResult(true, 200, "查询成功", menus);
    }

    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(int roleId) {
        List<String> ids = menuService.findMenuByRoleId(roleId);
        return new ResponseResult(true, 200, "查询成功", ids);
    }

    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVO roleMenuVO) {
        menuService.RoleContextMenu(roleMenuVO);
        return new ResponseResult(true, 200, "更新成功", null);
    }




}
