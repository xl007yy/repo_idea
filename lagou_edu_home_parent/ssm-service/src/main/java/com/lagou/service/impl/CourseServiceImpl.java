package com.lagou.service.impl;

import com.lagou.damian.Course;
import com.lagou.damian.CourseVO;
import com.lagou.damian.Teacher;
import com.lagou.dao.CourseMapper;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAllCourse(CourseVO courseVO) {
        List<Course> list = courseMapper.findAllCourse(courseVO);
        return list;
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVO);
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);
        courseMapper.saveCourse(course);
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);
        teacher.setCourseId(course.getId());
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);
        courseMapper.saveTeacher(teacher);
    }

    @Override
    public CourseVO findCourseById(int id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVO);
        Date date = new Date();
        course.setUpdateTime(date);
        courseMapper.updateCourse(course);
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(date);
        courseMapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(int id, int status) {
        Course course = new Course();
        course.setId(id);
        course.setStatus(status);
        course.setUpdateTime(new Date());
        courseMapper.updateCourseStatus(course);
    }


}
