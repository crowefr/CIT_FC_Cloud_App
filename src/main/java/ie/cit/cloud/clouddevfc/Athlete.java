package ie.cit.cloud.clouddevfc;

public class Athlete {

	public int id;
	public String username;
	public String password;
	public String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		username = username;
	}
	public String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		password = password;
	}

	private String firstName;
	private String surname;
	private String country;
	private String event;
	public String getFirstName() {
		return firstName;
	}
	public static void setFirstName(String firstName) {
		firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public static void setSurname(String surname) {
		surname = surname;
	}
	public String getCountry() {
		return country;
	}
	public static void setCountry(String country) {
		country = country;
	}
	public String getEvent() {
		return event;
	}
	public static void setEvent(String event) {
		event = event;
	}

	public int getId() {
		return id;
	}

	public static void setId(int id) {
		id = id;
	}
}
