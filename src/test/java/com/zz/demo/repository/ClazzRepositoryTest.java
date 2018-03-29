package com.zz.demo.repository;

import com.zz.demo.model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClazzRepositoryTest {

    @Resource
    private ClazzRepository clazzRepository;

    @Resource
    private TeacherRepository teacherRepository;

    @Test
    public void findByTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        teachers.forEach(teacher -> System.out.println(clazzRepository.findByTeachers_Id(teacher.getId())));
    }
}