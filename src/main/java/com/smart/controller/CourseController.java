package com.smart.controller;

import com.smart.dao.UserRepository;
import com.smart.entities.Course;
import com.smart.entities.User;
import com.smart.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserRepository userRepository;

    // method for adding common data to response
    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        String userName = principal.getName();
        System.out.println("USERNAME " + userName);
        // get the user using usernamne(Email)
        User user = userRepository.getUserByUserName(userName);
        System.out.println("USER " + user);
        model.addAttribute("user", user);
    }

    @GetMapping("/courses")
    @ResponseBody
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseByCourseId(@PathVariable String courseId) {
        return courseService.getCourseByCourseId(courseId);
    }

    @PostMapping("/courses")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public void updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
    }

    @DeleteMapping("courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

    @GetMapping("/courses/{courseId}/topics")
    public String showStudentCourses(@PathVariable("courseId") String courseId, Model model) {
        System.out.println("courseId " + courseId);
        model.addAttribute("topics", courseService.getTopicsByCourseId(courseId));
        return "normal/topic_detail";
    }

}
