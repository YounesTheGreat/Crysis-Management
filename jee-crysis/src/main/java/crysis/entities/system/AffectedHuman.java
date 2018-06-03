package crysis.entities.system;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import crysis.entities.cases.AffectedSystemDescription;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class AffectedHuman {

	@Id
	private String CIN;
	private String firstName;
	private String lastName;
	private Date birthDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private AffectedSystemDescription affectedSystemDescription;
	
	public AffectedHuman() {}
	
	public AffectedHuman(String cIN, String firstName, String lastName, Date birthDate) {
		setCIN(cIN);
		setFirstName(firstName);
		setLastName(lastName);
		setBirthDate(birthDate);
	}

	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public AffectedSystemDescription getAffectedSystemDescription() {
		return affectedSystemDescription;
	}

	public void setAffectedSystemDescription(AffectedSystemDescription affectedSystemDescription) {
		this.affectedSystemDescription = affectedSystemDescription;
	}
	
}
