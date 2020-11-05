package com.burntcity.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vets")
public class Vet extends Person {
	@ManyToMany(fetch = FetchType.EAGER) // by default, Many Relationships are lazy
	@JoinTable(name="vet_specialties",  // the name of the table that will be created
		joinColumns = @JoinColumn(name="vet_id"),  // the name of this column will be
		inverseJoinColumns = @JoinColumn(name="speciality_id")) // the name of this column will be
	private Set<Speciality> specialities = new HashSet<>();
}
