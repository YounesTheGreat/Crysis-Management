package crysis.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class TreatmentSystemDescription {

	@OneToMany(mappedBy="treatmentSystemDescription")
	private List<Phase> phases;

	
	public TreatmentSystemDescription() {}
	
	public List<Phase> getPhases() {
		return phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

	
}
