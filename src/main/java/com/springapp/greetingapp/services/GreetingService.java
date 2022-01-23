package com.springapp.greetingapp.services;

import org.springframework.stereotype.Service;

import com.springapp.greetingapp.controllers.GreetingRestController;
import com.springapp.greetingapp.models.Greeting;

@Service
public class GreetingService implements IGreetingService {

	/***
	 * UC-3:- Ability for the Greeting App to give Greeting message with 1. User
	 * First Name and Last Name or 2. With just First Name or Last Name based on
	 * User attributes provides or 3. Just Hello World.
	 ***/

	@Override
	public Greeting greetingMessage() {
		return new Greeting(GreetingRestController.COUNTER.incrementAndGet(), "Hello World, This is Nikhil ...!");
	}

	@Override
	public Greeting greetingMessage(String name) {
		return new Greeting(GreetingRestController.COUNTER.incrementAndGet(),
				String.format(GreetingRestController.TEMPLATE_1, name));
	}

	@Override
	public Greeting greetingMessage(String firstName, String lastName) {
		if (firstName == null && lastName == null) {
			return greetingMessage();
		} else if (firstName == null) {
			return greetingMessage(lastName);
		} else if (lastName == null) {
			return greetingMessage(firstName);
		} else {
			return new Greeting(GreetingRestController.COUNTER.incrementAndGet(),
					String.format(GreetingRestController.TEMPLATE_2, firstName, lastName).toString());
		}
	}
}
