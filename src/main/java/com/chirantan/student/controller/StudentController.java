package com.chirantan.student.controller;
import com.chirantan.student.entity.Student;
import com.chirantan.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String addStudentHandler(Model model){
        System.out.println("New student form to be opened");
        Student student= new Student();
        model.addAttribute("student",student);
        return "add-student";
    }
    @PostMapping("/students")
    public String addStudent(@ModelAttribute("student")Student student){
        System.out.println("Adding a student: "+student.toString());
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("students/update/{id}")
    public String updateStudentHandler(@PathVariable("id")Long id,Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit-student";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable("id")Long id, @ModelAttribute("student") Student student, Model model){
        System.out.println("Updated Student = "+student.toString());
        studentService.updateStudent(student);
        return "redirect:/students";
    }


    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id")Long id){
        System.out.println("Deleting student with Id: "+id);
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
