package crysis.entities.system;

import javax.persistence.Entity;

@Entity
public class Good extends AffectedMaterial{

	private double estimatedPrice;
	
	public Good() {}

	public double getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(double estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}
}
