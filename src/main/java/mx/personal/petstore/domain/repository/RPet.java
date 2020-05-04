package mx.personal.petstore.domain.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.personal.petstore.domain.Pet;
import mx.personal.petstore.domain.TypePet;

@org.springframework.stereotype.Repository
public interface RPet extends JpaRepository<Pet, Long>{
	
	Page<Pet> findAll(Pageable pageable);
	Page<Pet> findAllByType(TypePet typePet,Pageable pageable);
	Optional<Pet> findById(Long id);

}
