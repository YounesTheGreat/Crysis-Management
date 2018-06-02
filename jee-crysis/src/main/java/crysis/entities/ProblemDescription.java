package crysis.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class ProblemDescription {

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private AffectedSystemDescription affectedSystemDescription;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private DisasterDescription disasterDescription;

	
	public ProblemDescription() {}
	
	public AffectedSystemDescription getAffectedSystemDescription() {
		return affectedSystemDescription;
	}

	public void setAffectedSystemDescription(AffectedSystemDescription affectedSystemDescription) {
		this.affectedSystemDescription = affectedSystemDescription;
	}

	public DisasterDescription getDisasterDescription() {
		return disasterDescription;
	}

	public void setDisasterDescription(DisasterDescription disasterDescription) {
		this.disasterDescription = disasterDescription;
	}	
	
}
