package com.mongo.service;

import com.mongo.entities.Student;
import com.mongo.repository.DepartmentRepository;
import com.mongo.repository.StudentRepository;
import com.mongo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public Student createStudent(Student student) {
        if(student.getDepartment()!=null){
            departmentRepository.save(student.getDepartment());
        }

        if(student.getSubjects() != null && student.getSubjects().size()>0){
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    public Student findById(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> findAllDocuments() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Success";
    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.getByGivenName(name);
    }

    public List<Student> getStudentByNameAndEmail(String name, String email) {
        return studentRepository.getByNameAndEmail(name, email);
    }

    public List<Student> getStudentByNameOrEmail(String name, String email) {
        return studentRepository.getByNameOrEmail(name, email);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllWithSorting() {
        Sort sort = Sort.by(Sort.Direction.DESC,"name");
        return studentRepository.findAll(sort);
    }

    public List<Student> getByDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    public List<Student> getByEmailLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> nameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> byDepartmentId(String deptId) {
        return studentRepository.findByDepartmentId(deptId);
    }
}
