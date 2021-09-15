package com.springexample.example.services;

import com.springexample.example.daos.StudentRepository;
import com.springexample.example.domain.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) throws IllegalAccessException {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

        if(studentByEmail.isPresent())
            throw new IllegalAccessException("Email taken");

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) throws IllegalAccessException {
        boolean exists = studentRepository.existsById(studentId); // Equivalent of findById

        if(!exists)
            throw new IllegalAccessException("Student with id " + studentId + "does not exist");

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name) { // In video, the example also updates the email ("Exercise solution")
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + "does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
            student.setName(name);
    }
}
