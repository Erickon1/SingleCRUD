package mx.personal.petstore.interfaces;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.personal.petstore.domain.Pet;
import mx.personal.petstore.dto.PetDto;

public interface IPet {
	
	Page<Pet> get(Pageable pageable);
	Pet create(PetDto pet);
	Pet update(Long id,PetDto pet);
	void delete(Long id);
	
}
