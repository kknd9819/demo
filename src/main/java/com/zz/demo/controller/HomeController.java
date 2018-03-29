package com.zz.demo.controller;

import com.zz.demo.model.Clazz;
import com.zz.demo.model.Student;
import com.zz.demo.service.ClazzService;
import com.zz.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HomeController {

    @Resource
    private ClazzService clazzService;
    @Resource
    private StudentService studentService;


    @GetMapping("/")
    public List<Clazz> getClazz(){
        return clazzService.findAll();
    }

    @GetMapping("/1")
    public List<Student>getStudent(){
        return studentService.findAll();
    }
}
