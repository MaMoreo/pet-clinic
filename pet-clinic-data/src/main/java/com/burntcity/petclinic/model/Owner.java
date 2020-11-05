package com.burntcity.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
@Table(name = "owners") // name the Table
public class Owner extends Person {
	
	// Contact
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String telephone;
	
	//CASCADE.ALL = if I delete Owner, pets will be deleted too
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")  
	private Set<Pet> pets = new HashSet<>();
}
