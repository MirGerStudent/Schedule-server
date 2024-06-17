package org.example.core.configs;

import org.example.core.repository.StudentsRepository;
import org.example.core.repository.interfaces.IStudentsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;

@Configuration
public class RepositoryConfig {
    @Bean
    IStudentsRepository studentsRepository(JdbcOperations JdbcOperations) {
        return new StudentsRepository(JdbcOperations);
    }
}
