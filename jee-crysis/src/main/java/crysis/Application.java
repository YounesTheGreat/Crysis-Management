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

@SpringBootApplication
@EnableAutoConfiguration
public class Application  implements CommandLineRunner{

	@Autowired
	CasesRepository casesRepository;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World ..");
		Case myCase = casesRepository.save(new Case());
		System.out.println(myCase.getIdCase());
		
		testCasesInsert();
		testCasesInsert_withAffectedSys();
		testRetrieveCase_withAffectedSys();
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
