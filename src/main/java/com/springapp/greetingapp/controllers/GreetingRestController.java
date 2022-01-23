package com.springapp.greetingapp.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.greetingapp.models.Greeting;
import com.springapp.greetingapp.models.User;
import com.springapp.greetingapp.services.GreetingService;
import com.springapp.greetingapp.services.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingRestController {

	public static final String TEMPLATE_1 = "Hello %s!";
	public static final String TEMPLATE_2 = "Hello %s %s!";
	public static final AtomicLong COUNTER = new AtomicLong();

	/***
	 * UC-2:- Extend GreetingController to use Services Layer to get Simple Greeting
	 * message ”Hello World”.
	 ***/
	@Autowired
	private IGreetingService greetingService;

	@RequestMapping(value = { "", "/", "/home" }, method = RequestMethod.GET)
	public Greeting sayHello() {
		return greetingService.greetingMessage();
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public Greeting sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return greetingService.greetingMessage(name);
	}

	@RequestMapping(value = "/param/{name}", method = RequestMethod.GET)
	public Greeting sayHelloParam(@PathVariable String name) {
		return greetingService.greetingMessage(name);

	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
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

	@RequestMapping(value = "/put/{firstName}", method = RequestMethod.PUT)
	public Greeting sayHello(@PathVariable String firstName,
			@RequestParam(value = "lastName", defaultValue = "Sundarasetty") String lastName) {
		return greetingService.greetingMessage(firstName, lastName);
	}
}
