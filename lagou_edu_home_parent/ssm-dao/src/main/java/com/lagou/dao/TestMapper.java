package com.lagou.dao;

import com.lagou.damian.Test;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {

    @Select("select * from account")
    List<Test> findAll();
}
