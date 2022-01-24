package com.springapp.greetingapp.services;

import com.springapp.greetingapp.models.Greeting;

public interface IGreetingService {
	/** Declaring methods. **/
	public Greeting greetingMessage();

	public Greeting greetingMessage(String name);

	public Greeting greetingMessage(String firstName, String lastName);
	
	public Greeting findMssgById(String id);
}
