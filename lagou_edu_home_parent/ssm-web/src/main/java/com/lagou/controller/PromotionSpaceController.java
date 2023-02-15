package com.lagou.controller;

import com.lagou.damian.PromotionSpace;
import com.lagou.damian.ResponseResult;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> promotionSpaces = promotionSpaceService.findAllPromotionSpace();
        return new ResponseResult(true, 200, "响应成功", promotionSpaces);
    }

    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace){
        if (promotionSpace.getId() != null) {
            promotionSpaceService.updatePromotionSpace(promotionSpace);
        } else {
            promotionSpaceService.savePromotionSpace(promotionSpace);
        }
        return new ResponseResult(true, 200, "响应成功", null);

    }

    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(int id) {
        PromotionSpace promotionSpace = promotionSpaceService.findPromotionSpaceById(id);
        return new ResponseResult(true, 200, "响应成功", promotionSpace);
    }
}
