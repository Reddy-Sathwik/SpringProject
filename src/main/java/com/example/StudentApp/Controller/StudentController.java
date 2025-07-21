package com.example.StudentApp.Controller;

import org.springframework.ui.Model;
//import ch.qos.logback.core.model.Model;
import com.example.StudentApp.Model.Student;
import com.example.StudentApp.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {

    @Autowired
    StudentRepository repo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student) {
        repo.save(student);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", repo.findAll());
        return "students";
    }
}

