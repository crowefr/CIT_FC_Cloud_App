package ie.cit.cloud.clouddevfc;

import java.security.*;
import java.math.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;

public class JDBCathleterepository {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCathleterepository(DataSource athleteData) {
		this.jdbcTemplate = new JdbcTemplate(athleteData);
	}
	
	//Empty constructor for TracingAspect (AOP)
	JDBCathleterepository() {
	}
	
	public void save(Athlete athlete) {
		String hashedPasswd = hashPassword(athlete.getPassword());
		
		jdbcTemplate.update("insert into ATHLETE (username, password, fname, sname, event, country) values(?,?,?,?,?,?)",
		athlete.getUsername(), hashedPasswd, athlete.getFirstName(), athlete.getSurname(), athlete.getEvent(), athlete.getCountry());
		
		//insert - user table
		jdbcTemplate.update("insert into users (username, password, enabled) values (?, ?, true)",
		athlete.getUsername(), hashedPasswd);
		
		//insert - roles table
		jdbcTemplate.update("insert into authorities (username, authority) values (?,'ROLE_USER')",
		athlete.getUsername());
		
		int id = jdbcTemplate.queryForInt( "select max(id) from ATHLETE" );
		athlete.setId(id);
	}
	
	public Athlete get(int id) {
		return jdbcTemplate.queryForObject(
				"select * from ATHLETE where id=?", new AthleteMapper(),
				id);
	}
	
	public Athlete getAthleteLoggedIn() {
		return jdbcTemplate.queryForObject(
				"select * from ATHLETE where username=?", new AthleteMapper(), getCurrentUser());
	}

	private String getCurrentUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public List<Athlete> getAll() {
		return jdbcTemplate.query(
				"select * from ATHLETE", new AthleteMapper());
	}
	
	public void delete(int id) {
		jdbcTemplate.update("delete from ATHLETE where id=?", id);
	}
	
	public void update(Athlete athlete) {
		jdbcTemplate.update("update Athlete set event=? where id=?",
				athlete.getEvent(), athlete.getId());
	}
	
	public void updateProfile(Athlete athlete) {
		jdbcTemplate.update("update Athlete set fname=?, sname=?, club=? where id=?",
				athlete.getFirstName(), athlete.getSurname(), athlete.getCountry(), athlete.getId());
		System.out.println("Checking FirstName: " + athlete.getFirstName());
		System.out.println("Checking Surame: " + athlete.getSurname());
		System.out.println("Checking Club: " + athlete.getCountry());
		System.out.println("Checking Id: " + athlete.getId());
	}
	
		public static String hashPassword(String password) {
		String hashword = null;
		try {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(password.getBytes());
		BigInteger hash = new BigInteger(1, md5.digest());
		hashword = hash.toString(16);
		} catch (NoSuchAlgorithmException nsae) {
		// ignore
		}
		return hashword;
		}
	
	class AthleteMapper implements RowMapper<Athlete> {

		public Athlete mapRow(ResultSet rs, int rowNum) throws SQLException {
			Athlete athlete = new Athlete();
			Athlete.setId(rs.getInt("id"));
			Athlete.setUsername(rs.getString("username"));
			Athlete.setPassword(rs.getString("password"));
			Athlete.setFirstName(rs.getString("fname"));
			Athlete.setSurname(rs.getString("sname"));
			Athlete.setEvent(rs.getString("event"));
			Athlete.setCountry(rs.getString("country"));
			return athlete;
		}
	}
}
