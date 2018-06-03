package crysis.entities.system;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Victim extends AffectedHuman{

	public Victim() {}
	
	public Victim(String cIN, String firstName, String lastName, Date birthDate) {
		super(cIN, firstName, lastName, birthDate);
	}
}
