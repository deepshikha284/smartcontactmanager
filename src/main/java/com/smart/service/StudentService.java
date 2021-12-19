package com.smart.service;

import com.smart.entities.Course;
import com.smart.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

    List<Course> getCoursesByStudentId(Long studentId);

    List<Student> getStudentsByUserName(String userName);
}
