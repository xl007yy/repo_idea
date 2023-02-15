package com.lagou.dao;

import com.lagou.damian.Course;
import com.lagou.damian.CourseSection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseContentMapper {

    List<CourseSection> findSectionAndLessonByCourseId(int courseId);

    @Select("select id,course_name from course where id = #{id}")
    Course findCourseByCourseId(int courseId);

    void saveSection(CourseSection courseSection);

    void updateSection(CourseSection courseSection);
}
