package crysis.entities.cases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DisasterDescription {

	@Id
	@GeneratedValue
	private Long idDisasterDescription;

	private String fullDescription;
	private double longitude, latitude;
	
	public DisasterDescription() {}

	public Long getIdDisasterDescription() {
		return idDisasterDescription;
	}

	public void setIdDisasterDescription(Long idDisasterDescription) {
		this.idDisasterDescription = idDisasterDescription;
	}

	public String getDescription() {
		return fullDescription;
	}

	public void setDescription(String description) {
		this.fullDescription = description;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
