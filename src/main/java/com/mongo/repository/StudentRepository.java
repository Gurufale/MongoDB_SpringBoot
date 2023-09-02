package com.mongo.repository;

import com.mongo.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

    List<Student> getByName(String name);

    @Query("{\"name\" : \"?0\"}")
    List<Student> getByGivenName(String name);

    List<Student> getByNameAndEmail(String  name,String email);

    List<Student> getByNameOrEmail(String name, String email);

    List<Student> findByDepartmentDepartmentName(String departName);

    List<Student> findByEmailIsLike(String email);
    List<Student> findByNameStartsWith(String name);

    List<Student> findByDepartmentId(String deptId);
}
