package com.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.mongo.repository")
public class MongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}

}
