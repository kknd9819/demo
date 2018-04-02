package com.zz.demo.controller;

import com.alibaba.fastjson.JSON;
import com.zz.demo.model.Clazz;
import com.zz.demo.model.HS;
import com.zz.demo.model.Student;
import com.zz.demo.service.ClazzService;
import com.zz.demo.service.StudentService;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
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

    @GetMapping("/hs")
    public String getHs() throws IOException {
        File file= ResourceUtils.getFile("classpath:hs.txt");
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt;
        double value = 0;
        while((lineTxt = bufferedReader.readLine()) != null){
            System.out.println(lineTxt);
            HS hs1 = JSON.parseObject(lineTxt, HS.class);
            value += hs1.getSaleprice() * hs1.getQuantity();
        }
        return "金额: " + value;
    }
}
