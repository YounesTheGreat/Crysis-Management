package crysis.entities.cases;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TreatmentSystemDescription {

	@Id
	@GeneratedValue
	private Long idTsd;
	
	private String fullDescription;
	
	@OneToMany(mappedBy="treatmentSystemDescription")
	private List<Phase> phases;

	
	public TreatmentSystemDescription() {}
	
	public List<Phase> getPhases() {
		return phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

	public Long getIdTsd() {
		return idTsd;
	}

	public void setIdTsd(Long idTsd) {
		this.idTsd = idTsd;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

}
