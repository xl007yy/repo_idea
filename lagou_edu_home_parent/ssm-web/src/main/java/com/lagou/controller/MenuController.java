package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.damian.Menu;
import com.lagou.damian.MenuVo;
import com.lagou.damian.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(MenuVo menuVo){
        PageInfo<Menu> menuPageInfo = menuService.findAllMenu(menuVo);
        return new ResponseResult(true, 200, "查询成功", menuPageInfo);
    }

    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(int id){
        HashMap<String, Object> map = new HashMap<>();
        List<Menu> parentMenuList = menuService.findSubMenuListByPid(-1);
        map.put("parentMenuList", parentMenuList);
        if (id == -1){
            map.put("menuInfo", null);
        } else {
            Menu menu = menuService.findMenuById(id);
            map.put("menuInfo", menu);
        }
        return new ResponseResult(true, 200, "响应成功", map);


    }
}
