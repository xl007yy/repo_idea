package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.damian.PromotionAd;
import com.lagou.damian.PromotionAdVO;
import com.lagou.dao.PromotionMapper;
import com.lagou.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionMapper promotionMapper;

    @Override
    public PageInfo<PromotionAd> findAllPromotionAd(PromotionAdVO promotionAdVO) {
        PageHelper.startPage(promotionAdVO.getCurrentPage(),promotionAdVO.getPageSize());
        List<PromotionAd> allPromotionAd = promotionMapper.findAllPromotionAd();
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allPromotionAd);
        return pageInfo;
    }

    @Override
    public void updatePromotionAdStatus(PromotionAd promotionAd) {
        promotionAd.setUpdateTime(new Date());
        promotionMapper.updatePromotionAdStatus(promotionAd);
    }
}
