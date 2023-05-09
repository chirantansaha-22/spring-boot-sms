package com.chirantan.student.service;
import com.chirantan.student.entity.Student;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
public interface StudentService {

       List<Student> getAllStudents();
       Student saveStudent(Student student);

       Student getStudentById(Long id);

       Student updateStudent(Student student);

       void deleteStudentById(Long id);

}
