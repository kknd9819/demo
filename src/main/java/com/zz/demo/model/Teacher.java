package com.zz.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Teacher implements Serializable {

    private static final long serialVersionUID = 7013753830906478219L;


    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 64,nullable = false)
    private String name;
    @Column(length = 2,nullable = false)
    private Integer age;
    @Column(length = 1,nullable = false)
    private Integer sex;
    @Column(length = 64,nullable = false)
    private String subject;
    @JsonIgnore
    @ManyToMany(mappedBy = "teachers",targetEntity = Clazz.class)
    private Set<Clazz> clazzs = new HashSet<>();

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Clazz> getClazzs() {
        return clazzs;
    }

    public void setClazzs(Set<Clazz> clazzs) {
        this.clazzs = clazzs;
    }

}
