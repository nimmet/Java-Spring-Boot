package com.uyghur.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    @RequestMapping ("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        String result = "Yo! "+name;

        model.addAttribute("message",result);

        return "helloworld";
    }

    @RequestMapping("/doit")
    public String doItDifferent(@RequestParam("studentName") String name, Model model){
        String result = "Ey Keremlik Allah! "+name.toUpperCase()+"\'a yardim et!!!";
        model.addAttribute("message",result);
        return "helloworld";
    }
}
