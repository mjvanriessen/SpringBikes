/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 28, 2023
 */
package bikes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bikes.beans.Bike;
import bikes.repo.IBikesRepo;
import jakarta.validation.Valid;

@Controller
public class WebController {
	@Autowired
	IBikesRepo repo;
	
	@GetMapping({ "/", "/viewAll" })
	public String viewAllBikes(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewBike(model);
		}
		model.addAttribute("bikes", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputBike")
	public String addNewBike(Model model) {
		Bike b = new Bike();
		model.addAttribute("newBike", b);
		return "input";
	}
	
	@PostMapping("/inputBike")
	public String addNewBike(@ModelAttribute Bike b, Model model) {
		repo.save(b);
		return viewAllBikes(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateBike(@PathVariable("id") long id, Model model) {
		Bike b = repo.findById(id).orElse(null);
		model.addAttribute("newBike", b);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseBike(Bike b, Model model) {
		repo.save(b);
		return viewAllBikes(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBike(@PathVariable("id") long id, Model model) {
		Bike b = repo.findById(id).orElse(null);
		repo.delete(b);
		return viewAllBikes(model);
	}

}
