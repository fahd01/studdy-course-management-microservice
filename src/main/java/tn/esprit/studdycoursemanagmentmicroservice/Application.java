package tn.esprit.studdycoursemanagmentmicroservice;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.studdycoursemanagmentmicroservice.entities.User;
import tn.esprit.studdycoursemanagmentmicroservice.repositories.UserRepository;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner run(UserRepository userRepository) {
        // Create user with id 1 in DB, if not already present
        // User with id 1 is necessary for now (my enrollments feature), until integrating with user work
        return args -> userRepository.findById(1L).ifPresentOrElse(
                user -> { System.out.println("User with ID 1 already exists");},
                () -> userRepository.save(new User("Test", "Test"))
        );
    }
}
