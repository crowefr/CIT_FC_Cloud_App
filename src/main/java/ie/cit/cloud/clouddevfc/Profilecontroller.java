package ie.cit.cloud.clouddevfc;

import ie.cit.cloud.clouddevfc.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"athleteprofile"})
public class Profilecontroller {

	@Autowired
	JDBCathleterepository Athleterepository;

	@RequestMapping(method = RequestMethod.GET)
	public void justShowPage(Model model) {
		model.addAttribute("athlete", Athleterepository.getAthleteLoggedIn());
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createNewAthlete(Model model, @RequestParam String username,
			@RequestParam String password,
			@RequestParam String firstName,
			@RequestParam String surname, @RequestParam String country, 
			@RequestParam String event) {
		Athlete athlete = new Athlete();
		athlete.setUsername(username);
		athlete.setPassword(password);
		athlete.setFirstName(firstName);
		athlete.setSurname(surname);
		athlete.setCountry(country);
		athlete.setEvent(event);

		Athleterepository.save(athlete);
		model.addAttribute("athletes", Athleterepository.getAthleteLoggedIn());
	}

	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAthlete(Model model, @RequestParam int athleteId) {
		Athleterepository.delete(athleteId);
		model.addAttribute("athlete", Athleterepository.getAthleteLoggedIn());
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateAthlete(Model model, @RequestParam int athleteId) {
		Athlete athlete = Athleterepository.get(athleteId);
		Athleterepository.updateProfile(athlete);
		model.addAttribute("athletes", Athleterepository.getAthleteLoggedIn());
	}
}
