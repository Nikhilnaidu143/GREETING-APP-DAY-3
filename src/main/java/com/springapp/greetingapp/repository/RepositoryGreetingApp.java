package com.springapp.greetingapp.repository;

import org.springframework.data.repository.CrudRepository;
import com.springapp.greetingapp.models.Greeting;

/*** Created interface which extends CrudRepository. ***/
public interface RepositoryGreetingApp extends CrudRepository<Greeting, Long> {

}
