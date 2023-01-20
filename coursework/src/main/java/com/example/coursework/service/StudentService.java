package com.example.coursework.service;

import com.example.coursework.entity.SpecimenEntity;
import com.example.coursework.exception.StudentAlreadyExistException;
import com.example.coursework.entity.StudentEntity;
import com.example.coursework.model.Student;
import com.example.coursework.repository.StudentRepo;
import com.example.coursework.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    public StudentEntity addOne(StudentEntity student) throws StudentAlreadyExistException {
        if (studentRepo.findByLogin(student.getLogin()) != null) {
            throw new StudentAlreadyExistException("Пользователь с таким ником уже существует!");
        }
        studentRepo.save(student);
        return studentRepo.findByLogin(student.getLogin());
    }

    public List<StudentEntity> getAll() {
        return (List<StudentEntity>) studentRepo.findAll();
    }

    public Student getOne(Long id) throws StudentNotFoundException {
        if (studentRepo.findById(id).isPresent()){
            return Student.toModel(studentRepo.findById(id).get());
        }
        throw new StudentNotFoundException("Студент не найден(");
    }

    public StudentEntity delOne(Long id) {
        StudentEntity student = studentRepo.findById(id).get();
        studentRepo.deleteById(id);
        return student;
    }

    public StudentEntity updateOne(StudentEntity student, Long id) {
        StudentEntity studentNotUpdated = studentRepo.findById(id).get();
        studentNotUpdated.setName(student.getName());
        studentNotUpdated.setSurname(student.getSurname());
        studentNotUpdated.setPatronymic(student.getPatronymic());
        studentNotUpdated.setLogin(student.getLogin());
        studentNotUpdated.setPassword(student.getPassword());
        studentNotUpdated.setWorkplace(student.getWorkplace());
        studentNotUpdated.setMark(student.getMark());
        return studentRepo.save(studentNotUpdated);
    }
}
