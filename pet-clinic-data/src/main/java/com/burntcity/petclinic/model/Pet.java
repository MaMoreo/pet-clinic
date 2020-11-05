package com.burntcity.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "type_id") 
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")  // This is just to specify the column's name
	private Owner owner;
	
	@Column
	private LocalDate birthDate;

}
