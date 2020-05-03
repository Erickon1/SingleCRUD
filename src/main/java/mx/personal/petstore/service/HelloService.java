package mx.personal.petstore.service;

import org.springframework.stereotype.Service;

import mx.personal.petstore.interfaces.IHello;

@Service
public class HelloService implements IHello {

	@Override
	public String hello() {
		return "respuesta desde service "
				+ "con injeccion de dependencias";
	}

}
