package com.lagou.service;

import com.lagou.damian.Course;
import com.lagou.damian.CourseSection;

import java.util.List;

public interface CourseContentService {

    List<CourseSection> findSectionAndLessonByCourseId(int courseId);

    Course findCourseByCourseId(int courseId);

    void saveSection(CourseSection courseSection);

    void updateSection(CourseSection courseSection);
}
