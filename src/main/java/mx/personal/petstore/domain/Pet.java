package mx.personal.petstore.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.ToString;


@Entity
@ToString(callSuper=true, includeFieldNames=true)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Pet extends AuditModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BigDecimal cost;

	@Column(nullable = true)
	private String extraInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_pet_id", referencedColumnName="id",nullable = false)
    @JsonIgnore 
    private TypePet typePet;
    
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at", nullable = true, updatable = true)
    private Date deletedAt;


    protected Pet() {
      // no-args constructor required by JPA spec
      // this one is protected since it shouldn't be used directly
    }
        
    public Pet(String name ,BigDecimal cost,
    		String extraInfo, TypePet type,
    		Date deletedAt) {
    	this.name = name;
    	this.cost = cost;
    	this.extraInfo = extraInfo;
    	this.typePet = type;
    	this.deletedAt = deletedAt;
    }
    public String getName() {return this.name;}
    public BigDecimal getCost() {return this.cost;}
    public String getExtraInfo() {return this.extraInfo;}
    public TypePet getType() {return this.typePet;}
    public Date getDeletedAt() {
        return deletedAt;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public void setCost(BigDecimal cost) {
    	this.cost = cost;
    }
    
    public void setExtraInfo(String extraInfo) {
    	this.extraInfo = extraInfo;
    }    
    
    public void setTypePet(TypePet typePet) {
    	this.typePet = typePet;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }   

    
}
