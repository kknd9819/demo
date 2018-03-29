package com.zz.demo.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1257790914882617512L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 64,nullable = false)
    private String name;
    @Column(length = 2,nullable = false)
    private Integer age;
    @Column(length = 1,nullable = false)
    private Integer sex;
    @ManyToOne(targetEntity = Clazz.class)
    private Clazz clazz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

}
