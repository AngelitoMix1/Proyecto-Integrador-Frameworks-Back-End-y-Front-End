package com.wisdom.demo.CrudDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wisdom.demo.CrudDemo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

