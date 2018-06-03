package crysis.entities.cases;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProblemDescription {

	@Id
	@GeneratedValue
	private Long idProblemDescription;
	
	@OneToOne(cascade=CascadeType.ALL)
	private AffectedSystemDescription affectedSystemDescription;
	
	@OneToOne(cascade=CascadeType.ALL)
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

	public Long getIdProblemDescription() {
		return idProblemDescription;
	}

	public void setIdProblemDescription(Long idProblemDescription) {
		this.idProblemDescription = idProblemDescription;
	}	
	
	
	
}
