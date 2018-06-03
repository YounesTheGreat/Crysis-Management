package crysis.entities.cases;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Solution {

	@Id
	@GeneratedValue
	private Long idSolution;
	
	@OneToOne(cascade=CascadeType.ALL)
	private TreatmentSystemDescription treatmentSystemDescription;

	
	public Solution() {}
	
	public TreatmentSystemDescription getTreatmentSystemDescription() {
		return treatmentSystemDescription;
	}

	public void setTreatmentSystemDescription(TreatmentSystemDescription treatmentSystemDescription) {
		this.treatmentSystemDescription = treatmentSystemDescription;
	}

	public Long getIdSolution() {
		return idSolution;
	}

	public void setIdSolution(Long idSolution) {
		this.idSolution = idSolution;
	}
	
	
}
