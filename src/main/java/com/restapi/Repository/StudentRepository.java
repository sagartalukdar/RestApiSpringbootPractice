package com.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.Entity.Student;

public interface StudentRepository extends JpaRepository<Student , Integer>{

}
