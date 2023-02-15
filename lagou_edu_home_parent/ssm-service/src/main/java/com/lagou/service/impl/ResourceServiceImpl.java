package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.damian.Resource;
import com.lagou.damian.ResourceVO;
import com.lagou.dao.ResourceMapper;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResource(ResourceVO resourceVO) {
        PageHelper.startPage(resourceVO.getCurrentPage(), resourceVO.getPageSize());
        List<Resource> resources = resourceMapper.findAllResource(resourceVO);
        PageInfo<Resource> resourcePageInfo = new PageInfo<>(resources);
        return resourcePageInfo;
    }
}
