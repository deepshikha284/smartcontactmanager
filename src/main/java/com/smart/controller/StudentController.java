package com.smart.controller;

import com.smart.dao.UserRepository;
import com.smart.entities.Student;
import com.smart.entities.User;
import com.smart.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

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

    @GetMapping("/students")
    public String listStudents(Model model, Principal principal) {
        String userName = principal.getName();
        List<Student> students = studentService.getStudentsByUserName(userName);
        model.addAttribute("students", students);
        return "normal/students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "normal/create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student, Principal principal) {
        String userName = principal.getName();
        User user = userRepository.getUserByUserName(userName);
        student.setUser(user);
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "normal/edit_student";
    }

    @PostMapping("students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,
                                Model model) {

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/courses")
    public String showStudentCourses(@PathVariable("studentId") Long studentId, Model model) {
        System.out.println("studentId " + studentId);
        model.addAttribute("courses", studentService.getCoursesByStudentId(studentId));
        return "normal/course_detail";
    }

}
