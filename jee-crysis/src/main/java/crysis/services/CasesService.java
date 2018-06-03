package crysis.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crysis.dao.CasesRepository;
import crysis.entities.cases.Case;
import crysis.entities.cases.DisasterDescription;
import crysis.entities.cases.ProblemDescription;
import crysis.entities.system.AffectedHuman;
import crysis.entities.system.AffectedMaterial;
import crysis.entities.system.CivilianSociety;
import crysis.entities.system.Victim;

@Service
public class CasesService implements ICasesService {

	@Autowired
	private CasesRepository casesRepository;
	
	@Override
	public Long createCase(String disasterDescription, double longitude, double latitude) {
		Case myCase = new Case();
		ProblemDescription problemDescription = new ProblemDescription();
		
		DisasterDescription disasterDesc = new DisasterDescription();
		disasterDesc.setDescription(disasterDescription);
		disasterDesc.setLatitude(latitude);
		disasterDesc.setLongitude(longitude);
		
		problemDescription.setDisasterDescription(disasterDesc);
		myCase.setProblemDescription(problemDescription);
		
		myCase = casesRepository.save(myCase);
		return myCase.getIdCase();
	}

	@Override
	public void updateDisasterDescription(Long idCase, String disasterDescription, double longitude, double latitude) {
		Optional<Case> opt = casesRepository.findById(idCase);
		if (opt.isPresent()) {
			Case myCase = opt.get();
			DisasterDescription disasterDesc = myCase.getProblemDescription().getDisasterDescription();
			disasterDesc.setDescription(disasterDescription);
			disasterDesc.setLatitude(latitude);
			disasterDesc.setLongitude(longitude);
			
			casesRepository.save(myCase);
		}
	}

	@Override
	public void addAffectedHuman(Long idCase, String CIN, String firstName, String lastName, Date birthDate,
			String victimOrCivilianSystem) {
		Optional<Case> opt = casesRepository.findById(idCase);
		if (opt.isPresent()) {
			Case myCase = opt.get();
			
			AffectedHuman affHumanSys = victimOrCivilianSystem.equalsIgnoreCase("Victim")
					? new Victim(CIN, firstName, lastName, birthDate)  
					: new CivilianSociety(CIN, firstName, lastName, birthDate);
				
			myCase.getProblemDescription()
				.getAffectedSystemDescription()
				.getAffectedHumans().add(affHumanSys);
			
			casesRepository.save(myCase);
		}
	}

	@Override
	public void addAffectedMaterial(Long idCase, String materialName, String materialDamageDescription) {
		Optional<Case> opt = casesRepository.findById(idCase);
		if (opt.isPresent()) {
			Case myCase = opt.get();
			
			AffectedMaterial affectedMaterial = new AffectedMaterial();
			affectedMaterial.setName(materialName);
			affectedMaterial.setDamageDescription(materialDamageDescription);
			
			myCase.getProblemDescription()
				.getAffectedSystemDescription()
				.getAffectedMaterials().add(affectedMaterial);
			
			casesRepository.save(myCase);
		}
	}

	@Override
	public Case findCaseById(Long idCase) {
		Case myCase = null;
		Optional<Case> opt = casesRepository.findById(idCase);
		if (opt.isPresent()) {
			myCase = opt.get();
		}
		return myCase;
	}

	
}
