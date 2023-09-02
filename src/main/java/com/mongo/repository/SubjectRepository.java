package com.mongo.repository;

import com.mongo.entities.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subject,String> {
}
