package com.example.coursework.service;


import com.example.coursework.entity.SpecimenEntity;
import com.example.coursework.entity.StudentEntity;
import com.example.coursework.model.Student;
import com.example.coursework.repository.SpecimenRepo;
import com.example.coursework.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecimenService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private SpecimenRepo specimenRepo;

    public SpecimenEntity addOne(SpecimenEntity specimen, Long studentId) {
        StudentEntity student = studentRepo.findById(studentId).get();
        specimen.setStudent(student);
        return specimenRepo.save(specimen);
    }

    public List<SpecimenEntity> getAll() {
        return (List<SpecimenEntity>) specimenRepo.findAll();
    }

    public Long delOne(Long id) {
        specimenRepo.deleteById(id);
        return id;
    }

    public SpecimenEntity updateOne(SpecimenEntity specimen, Long id) {
        SpecimenEntity specimenNotUpdated = specimenRepo.findById(id).get();
        specimenNotUpdated.setTexture(specimen.getTexture());
        specimenNotUpdated.setStructure(specimen.getStructure());
        specimenNotUpdated.setComposition(specimen.getComposition());
        specimenNotUpdated.setArea(specimen.getArea());
        specimenNotUpdated.setPaleo(specimen.getPaleo());
        specimenNotUpdated.setStudent(specimenNotUpdated.getStudent());
        return specimenRepo.save(specimenNotUpdated);



    }
}
