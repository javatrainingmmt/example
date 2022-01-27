package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Trainee;

import com.cg.service.TraineeService;

@RestController
@RequestMapping("/trainee")
public class TraineeController {
   
	@Autowired
    TraineeService tServ;
	
	
	@GetMapping("/allTrainee")
	public ResponseEntity<List<Trainee>> getAllTrainee(){
		List<Trainee> trainee= tServ.getAllTrainee();
		if(trainee.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!",	HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Trainee>>(trainee, HttpStatus.OK);
	}
	
	@GetMapping("/getTrainee/{traineeId}")
	public ResponseEntity<Optional<Trainee>> findProduct(@PathVariable("traineeId")Integer traineeId){
		Optional<Trainee> tr= tServ.getTraineeById(traineeId) ;
		if(tr==null) {
			return new ResponseEntity("Sorry! Products not found!",	HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Optional<Trainee>>(tr, HttpStatus.OK);
	}
	
	
	@PostMapping("/addTrainee")
	public ResponseEntity<Trainee> addTrainee(@RequestBody Trainee trainee){
		Trainee tr= tServ.addTrainee(trainee);
		if(tr==null)
		{
			return new ResponseEntity("Sorry! Products not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Trainee>(tr,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateTrainee")
	public ResponseEntity<Trainee> updateTrainee(@RequestBody Trainee trainee){
		Trainee tr= tServ.updateTrainee(trainee);
		if(tr==null)
		{
			return new ResponseEntity("Sorry! Products not available!",	HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Trainee>(tr,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTrainee/{traineeId}")
	public String deleteTrainee(@PathVariable("traineeId")Integer traineeId){
		String tr= tServ.deleteTrainee(traineeId);
		if(tr==null) {
			return "Record Not Found!!";
		}
		
		return tr;
	}
	
}
