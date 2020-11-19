package com.burntcity.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
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

	@Builder
	public Owner(Long id, String firstName, String lastName, 
			String address, String city, String telephone, Set<Pet> pets) {
		super(id, firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.pets = pets;
	}
	
	
}
