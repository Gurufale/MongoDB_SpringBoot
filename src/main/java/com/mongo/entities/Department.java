package com.mongo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "departments")
public class Department {

    @Id
    private String id;

    @Field(name="department_name")
    private String departmentName;

    private String location;
}
