package com.example.HelloWorld.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HelloWorld.models.Greeting;

@RestController
@EnableAutoConfiguration
public class HelloWorldController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting hello(@RequestParam(value = "name", defaultValue = "World") String name)   
	{  
	    //return "Hello World! RESTFul here.";  
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}  

}
