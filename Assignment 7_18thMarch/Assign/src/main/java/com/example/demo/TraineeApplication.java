package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TraineeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraineeApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(TraineeRepository repo) {
        return args -> {
            Trainee t = new Trainee();
            t.setTraineeId(1);
            t.setTraineeName("Vinayak");
            t.setTraineeDomain("Java");
            t.setTraineeLocation("Delhi");

            repo.save(t);

            System.out.println(" Data inserted into database");
        };
    }
}