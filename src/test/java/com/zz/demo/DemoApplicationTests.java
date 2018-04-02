package com.zz.demo;

import com.zz.demo.model.Clazz;
import com.zz.demo.model.Student;
import com.zz.demo.model.Teacher;
import com.zz.demo.model.enumeration.SexEnum;
import com.zz.demo.repository.ClazzRepository;
import com.zz.demo.repository.StudentRepository;
import com.zz.demo.repository.TeacherRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.security.Key;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private ClazzRepository clazzRepository;

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private TeacherRepository teacherRepository;

    @Test
    public void contextLoads() {

        Clazz c1 = new Clazz();
        c1.setName("三年二班");
        clazzRepository.saveAndFlush(c1);

        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(17);
        s1.setSex(SexEnum.MAN.getCode());
        s1.setClazz(c1);
        studentRepository.saveAndFlush(s1);

        Teacher t1 = new Teacher();
        t1.setAge(28);
        t1.setName("郑茁");
        t1.setSex(SexEnum.MAN.getCode());
        t1.setSubject("Java");
        t1.getClazzs().add(c1);
        c1.getTeachers().add(t1);
        teacherRepository.saveAndFlush(t1);
        clazzRepository.saveAndFlush(c1);

        Student s2 = new Student();
        s2.setName("李四");
        s2.setSex(SexEnum.MAN.getCode());
        s2.setAge(19);
        s2.setClazz(c1);
        studentRepository.saveAndFlush(s2);

        Student s3 = new Student();
        s3.setName("王五");
        s3.setSex(SexEnum.MAN.getCode());
        s3.setAge(20);
        s3.setClazz(c1);
        studentRepository.saveAndFlush(s3);

        Student s4 = new Student();
        s4.setName("赵六");
        s4.setSex(SexEnum.MAN.getCode());
        s4.setAge(17);
        s4.setClazz(c1);
        studentRepository.saveAndFlush(s4);

        Clazz c2 = new Clazz();
        c2.setName("四年三班");
        c2.getTeachers().add(t1);
        clazzRepository.saveAndFlush(c2);

        Student s5 = new Student();
        s5.setName("李丽");
        s5.setSex(SexEnum.WOMAN.getCode());
        s5.setAge(18);
        s5.setClazz(c2);
        studentRepository.saveAndFlush(s5);


        Student s6 = new Student();
        s6.setName("赵丽娟");
        s6.setSex(SexEnum.WOMAN.getCode());
        s6.setAge(18);
        s6.setClazz(c2);
        studentRepository.saveAndFlush(s6);

        Teacher t2 = new Teacher();
        t2.setAge(29);
        t2.setName("李铁柱");
        t2.setSubject("C#");
        t2.setSex(SexEnum.MAN.getCode());
        t2.getClazzs().add(c2);
        c1.getTeachers().add(t2);
        c2.getTeachers().add(t2);

        teacherRepository.saveAndFlush(t2);
        clazzRepository.saveAndFlush(c2);
    }

    @Test
    public void testJwt(){
        Key key = MacProvider.generateKey();

        String compactJws = Jwts.builder()
                .setSubject("Zheng Zhuo")
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        System.out.println(compactJws);
        assert Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().getSubject().equals("Zheng Zhuo");
    }

}
