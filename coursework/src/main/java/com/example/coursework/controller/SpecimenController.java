package com.example.coursework.controller;

import com.example.coursework.entity.SpecimenEntity;
import com.example.coursework.service.SpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specimens")
public class SpecimenController {

    @Autowired
    private SpecimenService specimenService;
    @PostMapping("/{student_id}")
    public ResponseEntity addOne(@RequestBody SpecimenEntity specimen,
                                      @PathVariable Long student_id) {
        try {
            specimenService.addOne(specimen, student_id);
            return ResponseEntity.ok("Образец успешно добавлен!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(specimenService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(specimenService.delOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateOne(@RequestBody SpecimenEntity specimen,
                                         @RequestParam Long id) {
        try {
            return ResponseEntity.ok(specimenService.updateOne(specimen, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
