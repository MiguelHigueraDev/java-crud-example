package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // READ
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // CREATE
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        // Todo: Improve validations
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken.");
        }
        studentRepository.save(student);

    }
}
