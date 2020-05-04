package mx.personal.petstore.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.personal.petstore.domain.TypePet;

@org.springframework.stereotype.Repository
public interface RTypePet extends JpaRepository<TypePet, Integer> {

	Page<TypePet> findAll(Pageable pageable);
	TypePet findByName(String name);
	
}
