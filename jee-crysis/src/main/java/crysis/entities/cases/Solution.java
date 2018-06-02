package crysis.entities.cases;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Solution {

	@OneToOne(cascade=CascadeType.ALL)
	private TreatmentSystemDescription treatmentSystemDescription;

	
	public Solution() {}
	
	public TreatmentSystemDescription getTreatmentSystemDescription() {
		return treatmentSystemDescription;
	}

	public void setTreatmentSystemDescription(TreatmentSystemDescription treatmentSystemDescription) {
		this.treatmentSystemDescription = treatmentSystemDescription;
	}
	
	
}
