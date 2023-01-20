package com.example.coursework.repository;

import com.example.coursework.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<StudentEntity, Long> {
    StudentEntity findByLogin(String login);
}
