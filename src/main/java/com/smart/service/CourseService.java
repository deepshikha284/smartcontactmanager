package com.smart.service;

import com.smart.entities.Course;
import com.smart.entities.Topic;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourses();

    public Course getCourseByCourseId(String courseId);

    public void addCourse(Course course);

    public void updateCourse(Course course);

    public void deleteCourse(String id);

    List<Topic> getTopicsByCourseId(String courseId);
}
