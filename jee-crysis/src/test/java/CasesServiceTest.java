import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import crysis.dao.CasesRepository;
import crysis.entities.cases.AffectedSystemDescription;
import crysis.entities.cases.Case;
import crysis.entities.cases.DisasterDescription;
import crysis.entities.cases.ProblemDescription;
import crysis.services.CasesService;
import crysis.services.ICasesService;

@RunWith(SpringRunner.class)
public class CasesServiceTest {
 
    @TestConfiguration
    static class CasesServiceTestContextConfiguration {
  
        @Bean
        public ICasesService casesService() {
            return new CasesService();
        }
    }
 
    @Autowired
    private CasesService casesService;
 
    @Autowired
    private CasesRepository casesRepository;
 
    @Test
    public void firstTest() {
		Long idCase = casesService.createCase("Disaster Description", 0.456, 172.04);
		casesService.addAffectedHuman(idCase, "AD213", "Younes", "Kasri",
				new Date(1996, 10-1, 25), "Victim");
		casesService.addAffectedHuman(idCase, "H003D", "Gary", "SpongeBob",
				new Date(1999, 2-1, 10), "CivilianSociety");
		casesService.updateDisasterDescription(idCase, "new Disaster Description", 120.245, 120.888);
		
		Case myCase = casesService.findCaseById(idCase);
		if (myCase == null) 
			System.out.println("NOT FOUND - idCase = "+idCase);
		else {
			ProblemDescription probDesc = myCase.getProblemDescription();
			DisasterDescription disasterDesc = probDesc.getDisasterDescription();
			AffectedSystemDescription affectedSysDesc = probDesc.getAffectedSystemDescription();
			
			assertThat(disasterDesc.getLatitude()).isEqualTo(120.245);
			assertThat(disasterDesc.getLongitude()).isEqualTo(120.888);
			assertThat(disasterDesc.getDescription()).isEqualTo("new Disaster Description");
			
			assertThat(affectedSysDesc.getAffectedHumans().size()).isEqualTo(2);
			
			affectedSysDesc.getAffectedHumans().forEach((human)->{
				if (human.getCIN().equals("AD213")) {
					assertThat(human.getClass().getSimpleName()).isEqualTo("Victim");
				} else if (human.getCIN().equals("")) {
					assertThat(human.getClass().getSimpleName()).isEqualTo("CivilianSociety");
				}
			});
		}
		
		System.out.println("Fin des Tests");
    }
}