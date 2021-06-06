package com.linkedin.studentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testGetStudentByName_returnsStudentDetails() {

        Student studentSaved = testEntityManager.persistFlushFind(new Student(null, "John"));

        Student studentRetrieved = studentRepository.getStudentByName(studentSaved.getName());

        then(studentRetrieved.getId()).isNotNull();
        then(studentRetrieved.getName()).isEqualTo("John");
    }

}
