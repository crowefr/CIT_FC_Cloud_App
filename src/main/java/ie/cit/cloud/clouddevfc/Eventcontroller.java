package ie.cit.cloud.clouddevfc;

//import ie.cit.cloud.clouddevfc.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"events"})
public class Eventcontroller {

	@Autowired
	JDBCeventrepository JDBCeventrepository;

	@RequestMapping(method = RequestMethod.GET)
	public void justShowPage(Model model) {
		model.addAttribute("events", JDBCeventrepository.getAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createNewEvent(Model model, @RequestParam String date,
			@RequestParam String venue,
			@RequestParam String winner) {
		Event event = new Event();
		
		event.setDate(date);
		event.setVenue(venue);
		event.setWinner(winner);

		JDBCeventrepository.save(event);
		model.addAttribute("event", JDBCeventrepository.getAll());
	}

	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateEvent(Model model, @RequestParam int eventId, 
			@RequestParam String winner) {
		
		Event event = JDBCeventrepository.get(eventId);
		event.setWinner(winner);
		
		JDBCeventrepository.update(event);
		model.addAttribute("events", JDBCeventrepository.getAll());
	}
}
