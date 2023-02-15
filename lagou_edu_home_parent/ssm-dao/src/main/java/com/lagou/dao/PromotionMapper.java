package com.lagou.dao;

import com.lagou.damian.PromotionAd;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PromotionMapper {

    /**
     * 分页查询
     */
    List<PromotionAd> findAllPromotionAd();

    @Update("update promotion_ad set status = #{status},updatetime = #{updateTime} where id = #{id}")
    void updatePromotionAdStatus(PromotionAd promotionAd);
}
