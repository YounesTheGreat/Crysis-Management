package crysis.entities.system;

import javax.persistence.Entity;

import crysis.entities.cases.AffectedSystemDescription;

@Entity
public class Good extends AffectedMaterial{

	private double estimatedPrice;
	
	public Good() {}

	public Good(String name, String damageDescription) {
		super(name, damageDescription);
	}
	
	public Good(String name, String damageDescription, double estimatedPrice) {
		super(name, damageDescription);
		setEstimatedPrice(estimatedPrice);
	}


	public double getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(double estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}
}
