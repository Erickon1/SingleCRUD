package mx.personal.petstore.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.personal.petstore.domain.Pet;
import mx.personal.petstore.domain.TypePet;
import mx.personal.petstore.domain.repository.RPet;
import mx.personal.petstore.domain.repository.RTypePet;
import mx.personal.petstore.dto.PetDto;
import mx.personal.petstore.interfaces.IPet;

@Service
public class PetService implements IPet{

	@Autowired
	RPet rPet;
	@Autowired
	RTypePet rTypePet;
	
	@Override
	public Page<Pet> get(Pageable pageable) {
		return rPet.findAll(pageable);
	}

	@Override
	public Pet create(PetDto dto) {		
		TypePet type = rTypePet.getOne(dto.typePet);
		Pet pet = new Pet(dto.name, dto.cost, dto.extraInfo, type,null );
		rPet.save(pet);
		return pet;
	}

	@Override
	public Pet update(Long id, PetDto dto) {
		Pet pet = rPet.getOne(id);
		if (dto.typePet != null) {
		  TypePet type = rTypePet.getOne(dto.typePet);
		  pet.setTypePet(type);
		}
		if (dto.name != null && !dto.name.isEmpty()) {
			pet.setName(dto.name);
		}
		if (dto.cost != null) {
			pet.setCost(dto.cost);
		}
		if (dto.extraInfo != null && !dto.extraInfo.isEmpty()) {
			pet.setExtraInfo(dto.extraInfo);
		}
		rPet.save(pet);
		return pet;
	}

	@Override
	public void delete(Long id) {
		Pet pet = rPet.getOne(id);
		pet.setDeletedAt(new Date());
		rPet.save(pet);
	}

}
