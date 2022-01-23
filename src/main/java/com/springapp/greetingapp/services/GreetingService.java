package com.springapp.greetingapp.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.springapp.greetingapp.models.Greeting;

@Service
public class GreetingService implements IGreetingService {
	
	private AtomicLong counter_id = new AtomicLong();
	
	@Override
	public Greeting greetingMessage() {
		return new Greeting(counter_id.incrementAndGet() , "Hello World, This is Nikhil ...!");
	}
}
