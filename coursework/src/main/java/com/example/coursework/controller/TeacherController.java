package com.example.coursework.controller;

import com.example.coursework.entity.TeacherEntity;
import com.example.coursework.exception.TeacherAlreadyExistException;
import com.example.coursework.exception.TeacherNotFoundException;
import com.example.coursework.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping()
    public ResponseEntity addOne(@RequestBody TeacherEntity teacher) {
        try {
            return ResponseEntity.ok(teacherService.addOne(teacher));
        } catch (TeacherAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping()
    public ResponseEntity getOne(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(teacherService.getOne(id));
        } catch (TeacherNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(teacherService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(teacherService.delOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping()
    public ResponseEntity updateOne(@RequestBody TeacherEntity teacher,
                                    @RequestParam Long id) {
        try {
            return ResponseEntity.ok(teacherService.updateOne(teacher, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


}
