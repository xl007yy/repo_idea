package com.lagou.service;

import com.lagou.damian.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {

    List<PromotionSpace> findAllPromotionSpace();

    void savePromotionSpace(PromotionSpace promotionSpace);

    void updatePromotionSpace(PromotionSpace promotionSpace);

    PromotionSpace findPromotionSpaceById(int id);
}
