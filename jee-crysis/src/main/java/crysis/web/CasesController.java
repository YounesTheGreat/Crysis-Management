package crysis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crysis.entities.cases.AffectedSystemDescription;
import crysis.entities.cases.Case;
import crysis.entities.cases.DisasterDescription;
import crysis.entities.cases.ProblemDescription;
import crysis.services.CasesService;

@RestController
@RequestMapping("/cases")
public class CasesController {

	@Autowired
	CasesService casesService;
	
	private static final Logger log = LoggerFactory.getLogger(CasesController.class);
	
    public void firstTest() {
		Long idCase = casesService.createCase("Disaster Description", 0.456, 172.04);
		/*casesService.addAffectedHuman(idCase, "AD213", "Younes", "Kasri",
				new Date(1996, 10-1, 25), "Victim");
		casesService.addAffectedHuman(idCase, "H003D", "Gary", "SpongeBob",
				new Date(1999, 2-1, 10), "CivilianSociety");*/
		casesService.updateDisasterDescription(idCase, "new Disaster Description", 120.245, 120.888);
		
		Case myCase = casesService.findCaseById(idCase);
		if (myCase == null) 
			System.out.println("NOT FOUND - idCase = "+idCase);
		else {
			ProblemDescription probDesc = myCase.getProblemDescription();
			DisasterDescription disasterDesc = probDesc.getDisasterDescription();
			AffectedSystemDescription affectedSysDesc = probDesc.getAffectedSystemDescription();
				
			if (disasterDesc.getLatitude() == 120.245)
				if(disasterDesc.getLongitude() ==120.888)
					if(disasterDesc.getDescription().equals("new Disaster Description"))
						System.out.println("OK - Retrieve Disaster Desc");
			
			if (affectedSysDesc.getAffectedHumans().size()==2)
				System.out.println("OK - 2");
			//assertEquals(affectedSysDesc.getAffectedHumans().size(),2);
			
			/*affectedSysDesc.getAffectedHumans().forEach((human)->{
				if (human.getCIN().equals("AD213")) {
					assertThat(human.getClass().getSimpleName()).isEqualTo("Victim");
				} else if (human.getCIN().equals("")) {
					assertThat(human.getClass().getSimpleName()).isEqualTo("CivilianSociety");
				}
			});*/
		}
    }

    @GetMapping("/")
	public Case index() {
    	firstTest();
    	System.out.println("Holalalalalalalal");
		return new Case();
	}
	
	@GetMapping("/new")
	public String newForm() {
		return null;
	}
	
	@PostMapping("/")
	public String create() {
		return null;
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		return null;
	}
	
	
	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") Long id) {
		return null;
	}
	
	@PatchMapping("/{id}")
	public String update(Model model, @PathVariable("id") Long id, String title, String description) {
		return null;
	}

	@DeleteMapping("/{id}")
	public String destroy(Model model, @PathVariable("id") Long id) {
		return null;
	}
	
}
