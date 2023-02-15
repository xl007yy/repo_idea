package com.lagou.dao;

import com.lagou.damian.PromotionSpace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PromotionSpaceMapper {

    @Select("select * from promotion_space")
    List<PromotionSpace> findAllPromotionSpace();

    @Insert("insert into promotion_space(name, spaceKey, createTime, updateTime) " +
            "values (#{name},#{spaceKey},#{createTime},#{updateTime});")
    void savePromotionSpace(PromotionSpace promotionSpace);


    void updatePromotionSpace(PromotionSpace promotionSpace);

    @Select("select * from promotion_space where id = #{id}")
    PromotionSpace findPromotionSpaceById(int id);
}
