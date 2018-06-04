package crysis.services;

import java.util.Date;
import java.util.List;

import crysis.entities.cases.Case;

public interface ICasesService {

	Long createCase(String disasterDescription, double longitude, double latitude);
	
	void updateDisasterDescription(Long idCase, String disasterDescription, double longitude, double latitude);
	
	void addAffectedHuman(Long idCase, String CIN,
		String firstName,
		String lastName,
		Date birthDate, String VictimOrCivilianSystem);
	
	void addAffectedMaterial(Long idCase, String materialName, 
			String materialDamageDescription, String goodOrNaturalSite);

	Case findCaseById(Long idCase);

	List<Case> findAll();
}
