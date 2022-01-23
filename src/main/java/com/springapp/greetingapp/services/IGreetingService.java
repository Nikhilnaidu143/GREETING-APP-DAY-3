package com.springapp.greetingapp.services;

import com.springapp.greetingapp.models.Greeting;

public interface IGreetingService {
	public Greeting greetingMessage();

	public Greeting greetingMessage(String name);

	public Greeting greetingMessage(String firstName, String lastName);
}
