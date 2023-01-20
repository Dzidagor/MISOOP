package com.example.coursework.service;

import com.example.coursework.entity.TeacherEntity;
import com.example.coursework.exception.TeacherAlreadyExistException;
import com.example.coursework.exception.TeacherNotFoundException;
import com.example.coursework.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    public TeacherEntity addOne(TeacherEntity teacher) throws TeacherAlreadyExistException {
        if (teacherRepo.findByLogin(teacher.getLogin()) != null) {
            throw new TeacherAlreadyExistException("Преподаватель с таким ником уже существует");

        }
        teacherRepo.save(teacher);
        return teacherRepo.findByLogin(teacher.getLogin());
    }

    public TeacherEntity getOne(Long id) throws TeacherNotFoundException {
        if (teacherRepo.findById(id).isPresent()) {
            return teacherRepo.findById(id).get();
        }
        throw new TeacherNotFoundException("Преподаватель не найден");
    }

    public List<TeacherEntity> getAll() {
        return (List<TeacherEntity>) teacherRepo.findAll();
    }

    public TeacherEntity delOne(Long id) throws TeacherNotFoundException {
        if (teacherRepo.findById(id).isPresent()) {
            TeacherEntity teacher = teacherRepo.findById(id).get();
            teacherRepo.deleteById(id);
            return teacher;
        }
        throw new TeacherNotFoundException("Преподаватель не найден");
    }

    public TeacherEntity updateOne(TeacherEntity teacher, Long id) throws TeacherNotFoundException {
        if (teacherRepo.findById(id).isPresent()) {
            TeacherEntity teacherNotUpdated = teacherRepo.findById(id).get();
            teacherNotUpdated.setName(teacher.getName());
            teacherNotUpdated.setSurname(teacher.getSurname());
            teacherNotUpdated.setPatronymic(teacher.getPatronymic());
            teacherNotUpdated.setLogin(teacher.getLogin());
            teacherNotUpdated.setPassword(teacher.getPassword());
            return teacherRepo.save(teacherNotUpdated);
        }
        throw new TeacherNotFoundException("Преподаватель не найден");
    }

}
