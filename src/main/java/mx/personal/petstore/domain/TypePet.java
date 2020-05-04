package mx.personal.petstore.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.ToString;


@Entity(name = "typePet")
@Table(name = "type_pet")
@ToString(of = {"id","name","description"},includeFieldNames=true)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class TypePet extends AuditModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //drop error of hibernate_sequence
	private Integer id;
	
	@Column(nullable=false,unique = true)
	private String name;
	
	@Column(nullable=true)
	private String description;
	
	
    @OneToMany(mappedBy="typePet",fetch = FetchType.LAZY) 
    @JsonIgnore 
    private Set<Pet> pets;
	
	
	protected TypePet() {
	  // no-args constructor required by JPA spec
	  // this one is protected since it shouldn't be used directly
	}
	
	public TypePet(String name,String description,Set<Pet> pets) {
		this.name = name;
		this.description = description;
		this.pets =pets;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	public Set<Pet> getPets(){return pets;}
	
}
