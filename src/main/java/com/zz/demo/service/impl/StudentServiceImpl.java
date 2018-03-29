package com.zz.demo.service.impl;

import com.zz.demo.model.Student;
import com.zz.demo.repository.StudentRepository;
import com.zz.demo.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
