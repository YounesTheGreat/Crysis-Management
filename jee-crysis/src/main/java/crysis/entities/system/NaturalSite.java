package crysis.entities.system;

import javax.persistence.Entity;

@Entity
public class NaturalSite extends AffectedMaterial {

	private double longitude, latitude;

	public NaturalSite() {}
	
	public NaturalSite(String name, String damageDescription) {
		super(name, damageDescription);
	}
	public NaturalSite(String name, String damageDescription, double longitude, double latitude) {
		super(name, damageDescription);
		setLongitude(longitude);
		setLatitude(latitude);
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
