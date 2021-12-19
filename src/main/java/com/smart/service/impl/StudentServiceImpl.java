package com.smart.service.impl;

import com.smart.dao.StudentRepository;
import com.smart.dao.UserRepository;
import com.smart.entities.Course;
import com.smart.entities.Student;
import com.smart.entities.User;
import com.smart.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        Student student = getStudentById(studentId);
        List<Course> courses = student.getCourses();
        return courses;
    }

    @Override
    public List<Student> getStudentsByUserName(String userName) {
        User user = userRepository.getUserByUserName(userName);
        List<Student> students = studentRepository.findStudentByUserId(user.getId());
        return students;
    }
}
