package com.burntcity.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass    //Hibernate won't map this in the DB
public class Person extends BaseEntity {
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "second_name")
	private String secondName;
}
