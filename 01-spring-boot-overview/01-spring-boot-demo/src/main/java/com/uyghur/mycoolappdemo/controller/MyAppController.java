package com.uyghur.mycoolappdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAppController {

    private String description = """
                Hallo Liebe Leute,\n
                Ich bin ein Uyghur und ich komme aus Easten Turkistan.\n
                Ich habe Computer Engineering studiert und arbeite bei einem Firma \n
                als Cybersecurity Specialist.
                """;


    @GetMapping("/")
    public String sayHello(){
        return "Hello Uyghur!";
    }

    @GetMapping("/uyghur")
    public String showMsg(){
        return description;
    }

    @GetMapping("/description")
    public String showDescription(){
        return "description";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k";
    }
}
