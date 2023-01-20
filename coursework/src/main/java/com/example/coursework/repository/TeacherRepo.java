package com.example.coursework.repository;

import com.example.coursework.entity.TeacherEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepo extends CrudRepository<TeacherEntity, Long> {
    TeacherEntity findByLogin(String login);
}
