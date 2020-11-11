package com.burntcity.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity {
	
	private String description;
	
	// MIKE: if you want to create this as a Bidirecctional mapping you need
	//@ManyToMany(mappedBy = "specialities")
	//private Set<Vet> vets = new HashSet<>();
}
