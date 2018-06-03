package crysis.entities.cases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DisasterDescription {

	@Id
	@GeneratedValue
	private Long idDisasterDescription;

	public DisasterDescription() {}

	public Long getIdDisasterDescription() {
		return idDisasterDescription;
	}

	public void setIdDisasterDescription(Long idDisasterDescription) {
		this.idDisasterDescription = idDisasterDescription;
	}
	
	
}
