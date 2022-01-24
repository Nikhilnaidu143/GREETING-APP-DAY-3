package com.springapp.greetingapp.services;

import java.util.List;

import com.springapp.greetingapp.models.Greeting;

public interface IGreetingService {
	/** Declaring methods. **/
	public Greeting greetingMessage();

	public Greeting greetingMessage(String name);

	public Greeting greetingMessage(String firstName, String lastName);

	public Greeting findMssgById(String id);

	public List<Greeting> fetchAllGreetMssgs = null; // Defining list of greeting type;

	public List<Greeting> fetchGreetList();
}
