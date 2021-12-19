package com.smart.service.impl;

import com.smart.dao.CourseRepository;
import com.smart.entities.Course;
import com.smart.entities.Topic;
import com.smart.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        super();
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        for (Course course : courseRepository.findAll()) {
            courses.add(course);
        }
        return courses;
    }

    public Course getCourseByCourseId(String courseId) {
        return courseRepository.findById(courseId).get();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Topic> getTopicsByCourseId(String courseId) {
        Course course = getCourseByCourseId(courseId);
        List<Topic> topics = course.getTopics();
        return topics;
    }
}
