package com.springapp.greetingapp.repository;

import org.springframework.data.repository.CrudRepository;
import com.springapp.greetingapp.models.Greeting;

public interface RepositoryGreetingApp extends CrudRepository<Greeting, Long> {

}
