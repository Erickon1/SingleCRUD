package mx.personal.petstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.personal.petstore.domain.Pet;
import mx.personal.petstore.dto.PetDto;
import mx.personal.petstore.service.PetService;

@RestController
public class PetController {

	@Autowired
	PetService petService;
	
	@ResponseBody
	@GetMapping(path = "/pet")
	public 	Page<Pet> getPets( Pageable pageable ){
		return petService.get(pageable);
	}
	
	@ResponseBody
	@PostMapping(path = "/pet")
	public ResponseEntity<Object> create(@Valid @RequestBody PetDto pet) {		
		return new ResponseEntity<>(petService.create(pet), HttpStatus.CREATED);
	}
	
	@ResponseBody
	@PutMapping(path = "/pet/{petId}")
	public ResponseEntity<Object> update(@PathVariable Long petId, @Valid @RequestBody PetDto pet) {
		return new ResponseEntity<>(petService.update(petId, pet), HttpStatus.OK);
	}
	
	@ResponseBody
	@DeleteMapping(path = "/pet/{petId}")
	public ResponseEntity<Object> delete(@PathVariable Long petId) {
		petService.delete(petId);
	    return new ResponseEntity<>("Pet is deleted successsfully", HttpStatus.OK);
	}
	
	
}
