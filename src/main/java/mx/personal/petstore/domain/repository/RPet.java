package mx.personal.petstore.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import mx.personal.petstore.domain.Pet;
import mx.personal.petstore.domain.TypePet;

public interface RPet extends Repository<Pet, Long>{
	
	Page<Pet> findAll(Pageable pageable);
	Page<Pet> findAllByType(TypePet typePet,Pageable pageable);
	Pet findById(Long id);

}
