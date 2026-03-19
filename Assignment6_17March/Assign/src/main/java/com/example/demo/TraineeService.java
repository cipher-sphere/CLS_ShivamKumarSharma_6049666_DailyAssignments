package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeService {

    @Autowired
    private TraineeRepository repo;

    public List<Trainee> getAllTrainees() {
        return repo.findAll();
    }

    public Optional<Trainee> getTraineeById(int id) {
        return repo.findById(id);
    }

    public List<Trainee> getTraineeByName(String name) {
        return repo.findByTraineeName(name);
    }

    public Trainee saveTrainee(Trainee trainee) {
        return repo.save(trainee);
    }

    public void deleteTrainee(int id) {
        repo.deleteById(id);
    }

    public Trainee updateTrainee(int id, Trainee newData) {
        return repo.findById(id).map(t -> {
            t.setTraineeName(newData.getTraineeName());
            t.setTraineeDomain(newData.getTraineeDomain());
            t.setTraineeLocation(newData.getTraineeLocation());
            return repo.save(t);
        }).orElseThrow(() -> new RuntimeException("Trainee not found"));
    }
}