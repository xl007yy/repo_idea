package com.lagou.dao;

import com.lagou.damian.Course;
import com.lagou.damian.CourseVO;
import com.lagou.damian.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {

    List<Course> findAllCourse(CourseVO courseVO);

    void saveCourse(Course course);

    void saveTeacher(Teacher teacher);

    CourseVO findCourseById(int id);

    void updateCourse(Course course);

    void updateTeacher(Teacher teacher);

    @Update("update course set status = #{status},update_time = #{updateTime} where id = #{id}")
    void updateCourseStatus(Course course);


}
