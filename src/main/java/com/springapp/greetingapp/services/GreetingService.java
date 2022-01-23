package com.springapp.greetingapp.services;

import org.springframework.stereotype.Service;

import com.springapp.greetingapp.controllers.GreetingRestController;
import com.springapp.greetingapp.models.Greeting;

@Service
public class GreetingService implements IGreetingService {

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
		return new Greeting(GreetingRestController.COUNTER.incrementAndGet(),
				String.format(GreetingRestController.TEMPLATE_2, firstName, lastName).toString());
	}
}
