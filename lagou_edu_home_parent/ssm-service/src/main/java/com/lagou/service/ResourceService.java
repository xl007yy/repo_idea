package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.damian.Resource;
import com.lagou.damian.ResourceVO;

import java.util.List;

public interface ResourceService {

    PageInfo<Resource> findAllResource(ResourceVO resourceVO);
}
