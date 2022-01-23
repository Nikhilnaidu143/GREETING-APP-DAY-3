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

	private static final String TEMPLATE_1 = "Hello %s!";
	private static final String TEMPLATE_2 = "Hello %s %s!";
	private static final AtomicLong COUNTER = new AtomicLong();

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
		return new Greeting(COUNTER.incrementAndGet(), String.format(TEMPLATE_1, name));
	}

	@RequestMapping(value = "/param/{name}", method = RequestMethod.GET)
	public Greeting sayHelloParam(@PathVariable String name) {
		return new Greeting(COUNTER.incrementAndGet(), String.format(TEMPLATE_1, name));
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public Greeting sayHello(@RequestBody User user) {
		return new Greeting(COUNTER.incrementAndGet(),
				String.format(TEMPLATE_2, user.getFirstName(), user.getLastName()));
	}

	@RequestMapping(value = "/put/{firstName}", method = RequestMethod.PUT)
	public Greeting sayHello(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
		return new Greeting(COUNTER.incrementAndGet(), String.format(TEMPLATE_2, firstName, lastName));
	}
}