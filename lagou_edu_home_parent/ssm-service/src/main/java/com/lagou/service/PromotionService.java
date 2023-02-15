package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.damian.PromotionAd;
import com.lagou.damian.PromotionAdVO;

import java.util.List;

public interface PromotionService {

    PageInfo<PromotionAd> findAllPromotionAd(PromotionAdVO promotionAdVO);

    void updatePromotionAdStatus(PromotionAd promotionAd);
}
