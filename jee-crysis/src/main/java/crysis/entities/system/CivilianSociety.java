package crysis.entities.system;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class CivilianSociety extends AffectedHuman {

	public CivilianSociety() {}
	
	public CivilianSociety(String CIN, String firstName, String lastName, Date birthDate) {
		super(CIN, firstName, lastName, birthDate);
	}
}
