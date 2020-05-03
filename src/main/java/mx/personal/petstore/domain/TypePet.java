package mx.personal.petstore.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "typePet")
@Table(name = "type_pet")
public class TypePet implements Serializable {

	/**
	 * this is required by Serializable
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //drop error of hibernate_sequence
	private Integer id;
	
	@Column(nullable=false,unique = true)
	private String name;
	
	@Column(nullable=true)
	private String description;
	
	
    @OneToMany(mappedBy="typePet", 
    		cascade = CascadeType.ALL,
    		fetch = FetchType.LAZY) 
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
	public Set<Pet> getPet(){return pets;}
	
}
