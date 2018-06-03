package crysis.entities.cases;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import crysis.entities.system.AffectedHuman;
import crysis.entities.system.AffectedMaterial;

@Entity
public class AffectedSystemDescription {

	@Id
	@GeneratedValue
	private Long idAsd;
	
	private String fullDescription;
	
	@OneToMany(mappedBy="affectedSystemDescription")
	private List<AffectedHuman> affectedHumans; 
	
	@OneToMany(mappedBy="affectedSystemDescription")
	private List<AffectedMaterial> affectedMaterials;
	
	public AffectedSystemDescription() {}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public List<AffectedHuman> getAffectedHumans() {
		return affectedHumans;
	}

	public void setAffectedHumans(List<AffectedHuman> affectedHumans) {
		this.affectedHumans = affectedHumans;
	}

	public List<AffectedMaterial> getAffectedMaterials() {
		return affectedMaterials;
	}

	public Long getIdAsd() {
		return idAsd;
	}

	public void setIdAsd(Long idAsd) {
		this.idAsd = idAsd;
	}

	public void setAffectedMaterials(List<AffectedMaterial> affectedMaterials) {
		this.affectedMaterials = affectedMaterials;
	}
	
	
}