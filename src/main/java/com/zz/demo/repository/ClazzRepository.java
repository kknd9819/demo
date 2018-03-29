package com.zz.demo.repository;

import com.zz.demo.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClazzRepository extends JpaRepository<Clazz,Long> {

    @Query("select c from Clazz c join fetch c.teachers t where t.id = ?1")
    List<Clazz> findByTeachers_Id(Long teacherId);
}
