package crysis.entities.system;

import javax.persistence.Entity;

@Entity
public class NaturalSite extends AffectedMaterial {

	private Long longitude, latitude;

	public NaturalSite() {}
	
	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	
}
