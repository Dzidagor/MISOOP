package com.example.coursework.entity;

import com.example.coursework.model.Student;
import jakarta.persistence.*;

@Entity
public class SpecimenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texture;
    private String structure;
    private String composition;
    private String area;
    private String paleo;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    public SpecimenEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPaleo() {
        return paleo;
    }

    public void setPaleo(String paleo) {
        this.paleo = paleo;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
