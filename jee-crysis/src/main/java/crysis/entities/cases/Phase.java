package crysis.entities.cases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Phase {

	@Id
	@GeneratedValue
	private Long idPhase;
	
	@ManyToOne
	private TreatmentSystemDescription treatmentSystemDescription;

	/**
	 * Attention ! Ici forEach new added Phase in the List of 
	 * TreatmentSystemDescription i must set the reference 
	 * in this object to avoid null pointer exception
	 */
	public Phase() {
		/* A remplacer plus tard avec setTreatlentDescription() */
		//treatmentSystemDescription = new TreatmentSystemDescription();
	}
	
	public TreatmentSystemDescription getTreatmentSystemDescription() {
		return treatmentSystemDescription;
	}

	public void setTreatmentSystemDescription(TreatmentSystemDescription treatmentSystemDescription) {
		this.treatmentSystemDescription = treatmentSystemDescription;
	}

	public Long getIdPhase() {
		return idPhase;
	}

	public void setIdPhase(Long idPhase) {
		this.idPhase = idPhase;
	}

	
}
