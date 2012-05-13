package ie.cit.cloud.clouddevfc;

import java.util.ArrayList;
import java.util.List;

public class Athleterepository {
	private List<Athlete> athlete = new ArrayList<Athlete>();

	public List<Athlete> getAthlete() {
		return athlete;
	}

	public void addAthlete(Athlete athlete) {
		((List<Athlete>) athlete).add(athlete);
	}

	public Object getAthletes() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object getAthleteLoggedIn() {
		// TODO Auto-generated method stub
		return null;
	}

	

}