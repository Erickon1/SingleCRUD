package mx.personal.petstore.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import mx.personal.petstore.domain.TypePet;

public interface RTypePet extends Repository<TypePet, Integer> {

	Page<TypePet> findAll(Pageable pageable);
	TypePet findByName(String name);
	
}
