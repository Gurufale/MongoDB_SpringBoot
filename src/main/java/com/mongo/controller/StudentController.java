package com.mongo.controller;

import com.mongo.entities.Student;
import com.mongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getById(@PathVariable String id) {
        return studentService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllDocuments() {
        return studentService.findAllDocuments();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/studentByName/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/studentsByNameAndEmail")
    public List<Student> getByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.getStudentByNameAndEmail(name, email);
    }

    @GetMapping("/studentByNameOrEmail")
    public List<Student> getByNameOrEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.getStudentByNameOrEmail(name, email);
    }


    @GetMapping("/allWithPagination")
    public List<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
        return studentService.getAllWithPagination(pageNo, pageSize);
    }

    @GetMapping("/allWithSorting")
    public List<Student> getAllWithSorting() {
        return studentService.getAllWithSorting();
    }

    @GetMapping("/getByDeptName")
    public List<Student> getByDepartmentName(@RequestParam String deptName) {
        return studentService.getByDepartmentName(deptName);
    }

    @GetMapping("/emailLike")
    public List<Student> emailLike(@RequestParam String email){
        return studentService.getByEmailLike(email);
    }

    @GetMapping("/nameStartsWith")
    public List<Student> nameStartsWith(@RequestParam String name){
        return studentService.nameStartsWith(name);
    }

    @GetMapping("/byDepartmentId")
    public List<Student> byDepartmentId(@RequestParam String deptId)
    {
        return studentService.byDepartmentId(deptId);
    }
}
