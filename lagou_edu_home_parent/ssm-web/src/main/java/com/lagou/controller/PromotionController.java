package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.damian.PromotionAd;
import com.lagou.damian.PromotionAdVO;
import com.lagou.damian.ResponseResult;
import com.lagou.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @RequestMapping("/findAllPromotionAd")
    public ResponseResult findAllPromotionAd(PromotionAdVO promotionAdVO){
        PageInfo<PromotionAd> allPromotionAd = promotionService.findAllPromotionAd(promotionAdVO);
        return new ResponseResult(true, 200, "广告分页查询成功", allPromotionAd);
    }

    @RequestMapping("/PromotionAdUpload")
    public ResponseResult PromotionAdUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException();
        }
        String realPath = request.getServletContext().getRealPath("/");

        String substring = realPath.substring(0, realPath.indexOf("ssm-web"));

        String filename = file.getOriginalFilename();

        String newFilename = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));

        String uploadPath = substring + "upload";

        File filePath = new File(uploadPath, newFilename);
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录" + filePath);
        }
        file.transferTo(filePath);

        HashMap<String, String> map = new HashMap<>();
        map.put("fileName", newFilename);
        map.put("filePath", "http://localhost:8080/upload/"+newFilename);
        return new ResponseResult(true, 200, "图片上传成功", map);
    }

    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(PromotionAd promotionAd){
        promotionService.updatePromotionAdStatus(promotionAd);
        return new ResponseResult(true, 200, "状态修改成功", null);
    }
}
