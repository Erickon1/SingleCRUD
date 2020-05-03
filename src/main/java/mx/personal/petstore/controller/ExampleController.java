package mx.personal.petstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
	@RequestMapping("/")
	String hello() {
		return "Hello world";
	}
	
}
