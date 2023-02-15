package com.lagou.controller;

import com.lagou.damian.Course;
import com.lagou.damian.CourseVO;
import com.lagou.damian.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAllCourse")
    public ResponseResult findAllCourse(@RequestBody CourseVO courseVO) {
        List<Course> list = courseService.findAllCourse(courseVO);
        return new ResponseResult(true, 200, "响应成功", list);
    }

    /**
     * 图片上传
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/courseUpload")
    public ResponseResult courseUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
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

    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        if (courseVO.getId() == 0){
            courseService.saveCourseOrTeacher(courseVO);
        } else {
            courseService.updateCourseOrTeacher(courseVO);
        }
        return new ResponseResult(true, 200, "响应成功", null);
    }

    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(int id) {

        CourseVO courseVO = courseService.findCourseById(id);
        return new ResponseResult(true, 200, "响应成功", courseVO);

    }

    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(int id, int status){

        courseService.updateCourseStatus(id,status);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("status", status);
        return new ResponseResult(true, 200, "修改状态成功", map);
    }


}