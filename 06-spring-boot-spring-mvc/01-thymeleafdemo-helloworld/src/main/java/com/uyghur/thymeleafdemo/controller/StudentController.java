package com.uyghur.thymeleafdemo.controller;

import com.uyghur.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;
    @GetMapping("showStudentForm")
    public String showForm(Model model){

        Student student = new Student();
        model.addAttribute("student",student);
        model.addAttribute("countries",countries);
        model.addAttribute("favLan",languages);
        model.addAttribute("systems",systems);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        System.out.printf("The Student: "+theStudent.getFirstName()+" "+theStudent.getLastName());

        return "student-confirmation";
    }


}
