package mx.personal.petstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pet implements Serializable{

	/**
	 * this is required by Serializable
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BigDecimal cost;

	@Column(nullable = false)
	private String extraInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_pet_id", referencedColumnName="id",nullable = false)
    private TypePet typePet;
	
    protected Pet() {
      // no-args constructor required by JPA spec
      // this one is protected since it shouldn't be used directly
    }
    
    public Pet(String name ,BigDecimal cost,
    		String extraInfo, TypePet type) {
    	this.name = name;
    	this.cost = cost;
    	this.extraInfo = extraInfo;
    	this.typePet = type;
    }
    public String getName() {return this.name;}
    public BigDecimal getCost() {return this.cost;}
    public String getExtraInfo() {return this.extraInfo;}
    public TypePet getType() {return this.typePet;}
    
}
