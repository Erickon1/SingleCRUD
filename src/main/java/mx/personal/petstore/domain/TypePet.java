package mx.personal.petstore.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypePet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //drop error of hibernate_sequence
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=true)
	private String description;
	
	protected TypePet() {
	        // no-args constructor required by JPA spec
	        // this one is protected since it shouldn't be used directly
	}
	public TypePet(String name,String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
}
