package com.example.coursework.controller;

import com.example.coursework.exception.StudentAlreadyExistException;
import com.example.coursework.entity.StudentEntity;
import com.example.coursework.service.StudentService;
import com.example.coursework.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public ResponseEntity addOne(@RequestBody StudentEntity student) {
        try {
            return ResponseEntity.ok(studentService.addOne(student));
        } catch (StudentAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping()
    public ResponseEntity getOne(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(studentService.getOne(id));
        } catch (StudentNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @GetMapping("/all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(studentService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.delOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping()
    public ResponseEntity updateOne(@RequestBody StudentEntity student,
                                        @RequestParam Long id) {
        try {
            return ResponseEntity.ok(studentService.updateOne(student, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
