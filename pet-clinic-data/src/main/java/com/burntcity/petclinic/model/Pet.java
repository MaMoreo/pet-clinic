package com.burntcity.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "type_id") 
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")  // This is just to specify the column's name
	private Owner owner;
	
	private LocalDate birthDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")   // this is NOT a column in the DB
	private Set<Visit> visits = new HashSet<>();

}
