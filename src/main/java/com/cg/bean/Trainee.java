package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="trainee1")
public class Trainee {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tid")
	@Min(value=100, message="must be greater than 1")  
	private int traineeId;
	
	@NotEmpty(message="Name is Mandatory")
	@Size(min=4,max=20,message="Minimum 4 and Maximum 20 characters required")
	@Column(name="tname")
	private String traineeName;
	
	@Column(name="tloc")
	private String traineeLoc;
	
	@Column(name="tdomain")
	private String traineeDomain;

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTraineeLoc() {
		return traineeLoc;
	}

	public void setTraineeLoc(String traineeLoc) {
		this.traineeLoc = traineeLoc;
	}

	public String getTraineeDomain() {
		return traineeDomain;
	}

	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	
	
	
}
