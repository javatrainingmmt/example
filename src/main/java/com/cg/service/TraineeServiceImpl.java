package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Trainee;
import com.cg.dao.TraineeDao;

@Service("traineeService")
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	TraineeDao tDao;
	
	@Override
	public List<Trainee> getAllTrainee() {
		
		return tDao.findAll();
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		return tDao.save(trainee);
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		
		return tDao.save(trainee);
	}

	@Override
	public String deleteTrainee(Integer traineeId) {
		Optional<Trainee> tr=tDao.findById(traineeId);
		if(tr!=null) {
			tDao.deleteById(traineeId);
			return "Record Deleted";
		}
		return null;
		
		
	}

	@Override
	public Optional<Trainee> getTraineeById(Integer traineeId) {
		
		return tDao.findById(traineeId);
	}
}
