package com.linkedin.studentservice;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }

    @Cacheable("students")
    public Student getStudentById(Long id) {
        return this.studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }
}
