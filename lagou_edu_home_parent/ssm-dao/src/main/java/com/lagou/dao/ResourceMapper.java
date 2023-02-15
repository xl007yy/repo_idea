package com.lagou.dao;

import com.lagou.damian.Resource;
import com.lagou.damian.ResourceVO;

import java.util.List;

public interface ResourceMapper {

    List<Resource> findAllResource(ResourceVO resourceVO);
}
