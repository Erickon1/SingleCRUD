package mx.personal.petstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.personal.petstore.service.HelloService;

@RestController
public class ExampleController {
	
	@Autowired
	HelloService helloService;
	
	@RequestMapping("/")
	String hello() {
		return helloService.hello();
	}
	
}
