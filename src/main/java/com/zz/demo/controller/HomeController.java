package com.zz.demo.controller;

import com.zz.demo.model.Clazz;
import com.zz.demo.repository.ClazzRepository;
import com.zz.demo.service.ClazzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HomeController {

    @Resource
    private ClazzService clazzService;

    @GetMapping("/")
    public List<Clazz> getClazz(){
        System.out.println("a");
        return clazzService.findAll();
    }
}
