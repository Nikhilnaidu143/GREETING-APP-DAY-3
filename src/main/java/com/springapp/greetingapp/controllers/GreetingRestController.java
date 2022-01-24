package com.springapp.greetingapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.greetingapp.models.Greeting;
import com.springapp.greetingapp.models.User;
import com.springapp.greetingapp.services.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingRestController {

	public static final String TEMPLATE_1 = "Hello %s!";
	public static final String TEMPLATE_2 = "Hello %s %s!";

	/***
	 * UC-2:- Extend GreetingController to use Services Layer to get Simple Greeting
	 * message ”Hello World”.
	 ***/
	@Autowired // AutoWired annotation is used for automatic dependency injection.
	private IGreetingService greetingService;

	@GetMapping(value = { "", "/", "/home" })
	public Greeting sayHello() {
		return greetingService.greetingMessage();
	}

	@GetMapping(value = "/query")
	public Greeting sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return greetingService.greetingMessage(name);
	}

	@GetMapping(value = "/param/{name}")
	public Greeting sayHelloParam(@PathVariable String name) {
		return greetingService.greetingMessage(name);
	}

	/** creating greetings in mysql database. **/
	@PostMapping(value = "/post")
	public Greeting sayHello(@RequestBody User user) {

		/***
		 * UC-3:- Ability for the Greeting App to give Greeting message with 1. User
		 * First Name and Last Name or 2. With just First Name or Last Name based on
		 * User attributes provides or 3. Just Hello World.
		 ***/

		if (user.getFirstName() == null && user.getLastName() == null) {
			return greetingService.greetingMessage();
		} else if (user.getFirstName() == null) {
			return greetingService.greetingMessage(user.getLastName());
		} else if (user.getLastName() == null) {
			return greetingService.greetingMessage(user.getFirstName());
		} else {
			return greetingService.greetingMessage(user.getFirstName(), user.getLastName());
		}
	}

	/*** Updating existing greeting message. ***/
	@PutMapping(value = "/put/{firstName}")
	public Greeting sayHello(@PathVariable String firstName,
			@RequestParam(value = "lastName", defaultValue = "Sundarasetty") String lastName) {
		return greetingService.greetingMessage(firstName, lastName);
	}

	/***
	 * UC-5:- Ability for the Greeting App to find a Greeting Message by Id in the
	 * Repository.
	 ***/
	@GetMapping(value = "/find/{id}")
	public Greeting getMssg(@PathVariable String id) {
		return greetingService.findMssgById(id);
	}

	/***
	 * UC-6:- Ability for the Greeting App to List all the Greeting Messages in the
	 * Repository.
	 ***/
	@GetMapping("/getAll")
	public List<Greeting> fetchGreetingMssgsList() {
		return greetingService.fetchGreetList();
	}

	/***
	 * UC-7:- Ability for the Greeting App to Edit a Greeting Messages in the
	 * Repository.
	 ***/
	@PutMapping("/update")
	public Greeting updateGreeting(@RequestBody Greeting greeting) {
		return greetingService.updateGreetingMssg(greeting);
	}

	/***
	 * UC-8:- Ability for the Greeting App to delete a Greeting Messages in the
	 * Repository.
	 ***/
	@DeleteMapping("/delete/{id}")
	public String deleteGreetingMssg(@PathVariable String id) {
		return greetingService.deleteGreetingMssgByID(id);
	}
}
