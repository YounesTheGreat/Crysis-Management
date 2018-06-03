package crysis.entities.cases;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CASES")
public class Case {

	@Id
	@GeneratedValue
	private Long idCase;
	

	@OneToOne(cascade=CascadeType.ALL)
	private ProblemDescription problemDescription;
	
	@OneToOne(cascade= {CascadeType.PERSIST,CascadeType.REFRESH,
			CascadeType.DETACH, CascadeType.REMOVE})
	private Solution solution;

	
	public Case() {
		problemDescription = new ProblemDescription();
		solution = new Solution();
	}	
	
	public ProblemDescription getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(ProblemDescription problemDescription) {
		this.problemDescription = problemDescription;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	
	public Long getIdCase() {
		return idCase;
	}

	public void setIdCase(Long idCase) {
		this.idCase = idCase;
	}

	
}
