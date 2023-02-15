package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.damian.Resource;
import com.lagou.damian.ResourceVO;
import com.lagou.damian.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVO resourceVO) {
        PageInfo<Resource> allResource = resourceService.findAllResource(resourceVO);
        return new ResponseResult(true, 200, "查询成功", allResource);
    }

}
