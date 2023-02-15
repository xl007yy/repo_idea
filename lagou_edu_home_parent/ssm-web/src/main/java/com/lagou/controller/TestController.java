package com.lagou.controller;

import com.lagou.damian.Test;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //@Controller + @ResponseBody
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService service;

    @RequestMapping("/findAll")
    public List<Test> findAll() {
        return service.findAll();
    }
}
