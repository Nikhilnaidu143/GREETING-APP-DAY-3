package com.springapp.greetingapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String message;
	
	/*** Default constructor. ***/
	public Greeting() {

	}

	/** Parameterized constructor. **/
	public Greeting(String message) {
		this.message = message;
	}

	/** Getter and Setter methods. **/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
