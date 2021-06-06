package com.linkedin.studentservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.BDDAssertions.then;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StudentServiceTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Test
    @DisplayName("Returning saved student from service layer")
    public void getStudentById_forSavedStudent_isReturned() {

        Student student = studentRepository.save(new Student(null, "John"));

        Student studentRetrieved = studentService.getStudentByName(student.getName());

        then(studentRetrieved.getName()).isEqualTo("John");
        then(studentRetrieved.getId()).isNotNull();
    }

}
