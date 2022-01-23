package com.springapp.greetingapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.greetingapp.controllers.GreetingRestController;
import com.springapp.greetingapp.models.Greeting;
import com.springapp.greetingapp.repository.RepositoryGreetingApp;

@Service
public class GreetingService implements IGreetingService {

	@Autowired
	private RepositoryGreetingApp greetingRepository;
	
	@Override
	public Greeting greetingMessage() {
		return greetingRepository.save(new Greeting("Hello World, This is Nikhil ...!"));
	}

	@Override
	public Greeting greetingMessage(String name) {
		return greetingRepository.save(new Greeting(String.format(GreetingRestController.TEMPLATE_1, name)));
	}

	@Override
	public Greeting greetingMessage(String firstName, String lastName) {
		return greetingRepository.save(new Greeting(String.format(GreetingRestController.TEMPLATE_2, firstName, lastName)));
	}
}
