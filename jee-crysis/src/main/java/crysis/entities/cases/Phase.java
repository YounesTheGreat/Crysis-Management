package crysis.entities.cases;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Phase {

	@ManyToOne
	private TreatmentSystemDescription treatmentSystemDescription;

	
	public Phase() {}
	
	public TreatmentSystemDescription getTreatmentSystemDescription() {
		return treatmentSystemDescription;
	}

	public void setTreatmentSystemDescription(TreatmentSystemDescription treatmentSystemDescription) {
		this.treatmentSystemDescription = treatmentSystemDescription;
	}

}
