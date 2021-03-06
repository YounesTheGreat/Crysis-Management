package crysis.entities.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import crysis.entities.cases.AffectedSystemDescription;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class AffectedMaterial {

	@Id
	@GeneratedValue
	private Long idMaterial;
	private String name;
	private String damageDescription;
	
	@ManyToOne
	private AffectedSystemDescription affectedSystemDescription;
	
	public AffectedMaterial() {}
	
	
	public AffectedMaterial(String name, String damageDescription) {
		super();
		this.name = name;
		this.damageDescription = damageDescription;
	}


	public Long getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDamageDescription() {
		return damageDescription;
	}

	public void setDamageDescription(String damageDescription) {
		this.damageDescription = damageDescription;
	}

	public AffectedSystemDescription getAffectedSystemDescription() {
		return affectedSystemDescription;
	}

	public void setAffectedSystemDescription(AffectedSystemDescription affectedSystemDescription) {
		this.affectedSystemDescription = affectedSystemDescription;
	}

	
}
