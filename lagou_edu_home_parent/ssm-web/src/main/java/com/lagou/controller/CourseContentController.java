package com.lagou.controller;

import com.lagou.damian.Course;
import com.lagou.damian.CourseSection;
import com.lagou.damian.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLesson(@RequestParam int courseId){
        List<CourseSection> courseSections = courseContentService.findSectionAndLessonByCourseId(courseId);
        return new ResponseResult(true, 200, "查询成功", courseSections);
    }

    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(@RequestParam int courseId){
        Course course = courseContentService.findCourseByCourseId(courseId);
        HashMap<String, Object> map = new HashMap<>();
        return new ResponseResult(true, 200, "响应成功", course);
    }

    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){
        if (courseSection.getId() == null) {
            courseContentService.saveSection(courseSection);
        } else {
            courseContentService.updateSection(courseSection);
        }
        return new ResponseResult(true, 200, "响应成功", null);
    }

}
