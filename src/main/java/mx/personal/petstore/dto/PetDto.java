package mx.personal.petstore.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

public class PetDto {

	@Column(nullable = false)
	public String name;

	@Column(nullable = false)
	public BigDecimal cost;

	@Column(nullable = true)
	public String extraInfo;
	
	@Column(nullable = false)
	public Integer typePet;
	
}
