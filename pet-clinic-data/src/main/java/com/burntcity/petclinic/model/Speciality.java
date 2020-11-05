package com.burntcity.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity {
	
	//@ManyToMany(mappedBy = "specialities")  // this is NOT in the video
	private String description;
}
