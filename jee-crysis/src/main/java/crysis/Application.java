package crysis;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import crysis.dao.CasesRepository;
import crysis.entities.cases.AffectedSystemDescription;
import crysis.entities.cases.Case;
import crysis.entities.cases.DisasterDescription;
import crysis.entities.cases.ProblemDescription;
import crysis.entities.system.AffectedHuman;
import crysis.entities.system.Victim;
import crysis.services.ICasesService;

@SpringBootApplication
@EnableAutoConfiguration
public class Application  implements CommandLineRunner{

	@Autowired
	CasesRepository casesRepository;
	
	@Autowired
	ICasesService casesService;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World ..");
		
		/* Tests DAO */
		testCasesInsert();
		testCasesInsert_withAffectedSys();
		testRetrieveCase_withAffectedSys();
		
		/* Tests Facade Service */
		testCaseServices_createCase();
		testCasesService_addAffectedHuman();
		testCasesService_addAffectedMaterial();
	}

	private void testCasesService_addAffectedMaterial() {
		Long idCase = casesService.createCase("Blabla", 1000, 1000);
		casesService.addAffectedMaterial(idCase,"BMW 220", "pare brise endommagé", "Good");
		casesService.addAffectedMaterial(idCase, "Sawma3at Hassan", "ta7et", "NaturalSite");
	
		Case myCase = casesService.findCaseById(idCase);
		AffectedSystemDescription affectedSystemDescription = myCase.getProblemDescription().getAffectedSystemDescription();
		if (affectedSystemDescription.getAffectedMaterials().size() == 2 ) {
			affectedSystemDescription.getAffectedMaterials().forEach(System.out::println);
			System.out.println("OK - CaseService Test addAffectedMaterial");
		}else {
			System.out.println("NOT OK - CaseService Test addAffectedMaterial");
		}
	}

	private void testCasesService_addAffectedHuman() {
		Long idCase = casesService.createCase("DisasterDescription2", 100, 200);

		casesService.addAffectedHuman(idCase, "CIN3", "", "", new Date(), "Victim");
		casesService.addAffectedHuman(idCase, "H003D", "Gary", "SpongeBob",
				new Date(), "CivilianSociety");
		casesService.addAffectedHuman(idCase, "H045D", "Steve", "Carlos",
				new Date(), "CivilianSociety");
		
		Case retrievedCase = casesService.findCaseById(idCase);
		retrievedCase.getProblemDescription()
			.getAffectedSystemDescription()
			.getAffectedHumans().forEach(System.out::println);
		
		if (retrievedCase.getProblemDescription()
				.getAffectedSystemDescription()
				.getAffectedHumans().size() == 3) {
			System.out.println("OK - Service Add Affected Human");
		} else {
			System.out.println("NOT OK - Service Add Affected Human");
		}
	}

	private void testCaseServices_createCase() {
		System.out.println(casesService);		
		Long idCase = casesService.createCase("DisasterDescription", 10, 20);
		Case retrievedCase = casesService.findCaseById(idCase);
		DisasterDescription disasterDescription = retrievedCase.getProblemDescription()
				.getDisasterDescription();
		if (disasterDescription.getDescription().equals("DisasterDescription")
				&& disasterDescription.getLongitude() == (10)) {
			System.out.println("OK - Create Case  - from Service");
		} else {
			System.out.println("NOT  OK - Creaet Case -  from Service ");
		}
	}
	
	public void testCasesInsert() {
		Case myCase = new Case();
		
		ProblemDescription problemDescription = new ProblemDescription();
		DisasterDescription disasterDescription = new DisasterDescription();
		disasterDescription.setDescription("OMG Disaster");
		disasterDescription.setLatitude(120);
		disasterDescription.setLongitude(120);
		problemDescription.setDisasterDescription(disasterDescription);
		myCase.setProblemDescription(problemDescription);
		
		myCase = casesRepository.save(myCase);
		myCase.getProblemDescription();
		myCase.getProblemDescription().getDisasterDescription();
		
		if(myCase.getProblemDescription().getDisasterDescription().getDescription().equals("OMG Disaster"))
			System.out.println("OK - Insert Case->probDesc->disasterDesc");
		else
			System.out.println("OK - Insert Case->probDesc->disasterDesc");
	}
	
	public void testCasesInsert_withAffectedSys() {
		Case myCase = new Case();
		
		ProblemDescription problemDescription = new ProblemDescription();
		AffectedSystemDescription affectedSystemDescription
			= new AffectedSystemDescription();
		affectedSystemDescription.setFullDescription("FullDescription");
		affectedSystemDescription.getAffectedHumans()
			.add(new Victim("CIN", "firstName", "lastName", new Date()));

		problemDescription.setAffectedSystemDescription(affectedSystemDescription);
		myCase.setProblemDescription(problemDescription);
		myCase = casesRepository.save(myCase);
		
		Optional<AffectedHuman> opt = myCase.getProblemDescription().getAffectedSystemDescription()
				.getAffectedHumans().stream().findFirst();
		
		if (opt.isPresent()) {
			if (opt.get().getCIN().equals("CIN"))
				System.out.println("OK - Insert with Affected Sys");
		} else 
			System.out.println("NOT OK - Insert with Affected Sys");
	}

	public void testRetrieveCase_withAffectedSys() {
		Case myCase = new Case();
		
		ProblemDescription problemDescription = new ProblemDescription();
		AffectedSystemDescription affectedSystemDescription
			= new AffectedSystemDescription();
		affectedSystemDescription.setFullDescription("FullDescription");
		affectedSystemDescription.addAffectedHuman(new Victim("CIN2", "firstName", "lastName", new Date()));
		
		problemDescription.setAffectedSystemDescription(affectedSystemDescription);
		myCase.setProblemDescription(problemDescription);
		casesRepository.save(myCase);
		
		myCase = casesRepository.findById(myCase.getIdCase()).get();
		Optional<AffectedHuman> opt = myCase.getProblemDescription().getAffectedSystemDescription()
				.getAffectedHumans().stream().findFirst();
		System.out.println(myCase.getProblemDescription().getAffectedSystemDescription().getAffectedHumans().size());
		
		if (null != myCase.getProblemDescription().getAffectedSystemDescription().getAffectedHumans()
				&& opt.isPresent()) {
			if (opt.get().getCIN().equals("CIN2"))
				System.out.println("OK - Retrieve with Affected Sys");
		} else 
			System.out.println("NOT OK - Retrieve with Affected Sys");
	}
	
	
}
