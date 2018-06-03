package crysis.entities.cases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(mappedBy="affectedSystemDescription", cascade=CascadeType.ALL)
	private List<AffectedHuman> affectedHumans;
	
	@OneToMany(mappedBy="affectedSystemDescription", cascade=CascadeType.ALL)
	private List<AffectedMaterial> affectedMaterials;
	
	public AffectedSystemDescription() {
		affectedHumans = new ArrayList<>(); 
		affectedMaterials = new ArrayList<>();
	}

	/** Important */
	public void addAffectedHuman(AffectedHuman human) {
		human.setAffectedSystemDescription(this);
		affectedHumans.add(human);
	}
	
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
