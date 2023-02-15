package com.lagou.service;

import com.lagou.damian.Course;
import com.lagou.damian.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {

    List<Course> findAllCourse(CourseVO courseVO);

    void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    CourseVO findCourseById(int id);

    void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    void updateCourseStatus(int id, int status);
}
