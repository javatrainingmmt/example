package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.bean.Trainee;

@Service
public interface TraineeService {

	List<Trainee> getAllTrainee();

	public Trainee addTrainee(Trainee trainee);

	Trainee updateTrainee(Trainee trainee);

	String deleteTrainee(Integer traineeId);

	Optional<Trainee> getTraineeById(Integer traineeId);

}
