package crysis.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import crysis.entities.cases.Case;
import crysis.services.ICasesService;

@Controller
@RequestMapping("/cases")
public class CasesController {

	protected Logger logger = LoggerFactory.getLogger( getClass() );
	
	@Autowired
	ICasesService casesService;
	
    @RequestMapping("/cases")
	public String index(Model model) {
    	List<Case> cases = casesService.findAll();
    	model.addAttribute(cases);
    	return "cases";
	}
	
	@RequestMapping("/new")
	public String newForm() {
		return "new-case";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(String disasterDescription, double longitude, double latitude) {
		Long idCase = casesService.createCase(disasterDescription, longitude, latitude);
		return "redirect:/cases/"+idCase;
	}
	
	@RequestMapping("/{id}")
	public String show(Model model, @PathVariable("id") Long idCase) {
		Case myCase = casesService.findCaseById(idCase);
		model.addAttribute("case", myCase);
		return "show-case";
	}
	
	
	@RequestMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") Long id) {
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public String update(Model model, @PathVariable("id") Long id, String title, String description) {
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String destroy(Model model, @PathVariable("id") Long id) {
		return null;
	}
	
	/* Lorsque je veux factoriser avec @RequestMapping on my controler class. @PostMapping etc.. don't work well 
	 * That's why i used classic @RequestMapping on methods instead  
	 */
}
