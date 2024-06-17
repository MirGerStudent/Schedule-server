package org.example.core.configs;

import org.example.core.repository.interfaces.IStudentsRepository;
import org.example.core.service.StudentsService;
import org.example.core.service.interfaces.IStudentsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    IStudentsService studentsService(IStudentsRepository studentsRepository) {
        return new StudentsService(studentsRepository);
    }
}
