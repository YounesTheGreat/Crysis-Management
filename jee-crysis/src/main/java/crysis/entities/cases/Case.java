package crysis.entities.cases;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Case {

	@OneToOne(cascade=CascadeType.ALL)
	private ProblemDescription problemDescription;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Solution solution;

	
	public Case() {}	
	
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
	
	
	
}
