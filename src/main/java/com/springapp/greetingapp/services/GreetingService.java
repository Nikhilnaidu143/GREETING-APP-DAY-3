package com.springapp.greetingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.greetingapp.controllers.GreetingRestController;
import com.springapp.greetingapp.models.Greeting;
import com.springapp.greetingapp.repository.RepositoryGreetingApp;

@Service
public class GreetingService implements IGreetingService {

	/** AutoWired annotation is used for automatic dependency injection. **/
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
		return greetingRepository
				.save(new Greeting(String.format(GreetingRestController.TEMPLATE_2, firstName, lastName)));
	}

	/*** finding greeting mssg by id. ***/
	@Override
	public Greeting findMssgById(String id) {
		Optional<Greeting> greetingMssg = greetingRepository.findById(Long.parseLong(id));
		if (greetingMssg.isPresent()) {
			return greetingMssg.get();
		} else {
			return (new Greeting("Greeting message is not there."));
		}
	}

	/** Fetch all greeting mssgs in the repository. **/
	@Override
	public List<Greeting> fetchGreetList() {
		return (List<Greeting>) greetingRepository.findAll();
	}
}
