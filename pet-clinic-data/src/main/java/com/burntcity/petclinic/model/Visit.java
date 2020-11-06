package com.burntcity.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
	
	private LocalDate date;
	private String description;
	
	@ManyToOne     // this is a column in the DB
	@JoinColumn(name = "pet_id") 
	private Pet pet;   
}
