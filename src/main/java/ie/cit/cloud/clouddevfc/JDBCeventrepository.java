package ie.cit.cloud.clouddevfc;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCeventrepository {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCeventrepository(DataSource athleteData) {
		this.jdbcTemplate = new JdbcTemplate(athleteData);
	}
	
	// AOP
	JDBCeventrepository() {
	}
	
	public void save(Event event) {
		jdbcTemplate.update("insert into EVENT (eventdate, venue, winner) values(?,?,?)",
		event.getDate(), event.getVenue(), event.getWinner());
	}
	
	public Event get(int id) {
		return jdbcTemplate.queryForObject(
				"select * from EVENT where id=?", new EventMapper(),
				id);
	}

	public List<Event> getAll() {
		return jdbcTemplate.query(
				"select * from EVENT", new EventMapper());
	}
	
	public void delete(int id) {
		jdbcTemplate.update("delete from ATHLETE where id=?", id);
	}
	
	public void update(Event event) {
		jdbcTemplate.update("update EVENT set winner=? where id=?",
				event.getWinner(), event.getId());
	}
	
	class EventMapper implements RowMapper<Event> {

		public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
			Event event = new Event();
			event.setId(rs.getInt("id"));
			event.setDate(rs.getString("eventdate"));
			event.setVenue(rs.getString("venue"));
			event.setWinner(rs.getString("winner"));
			return event;
		}
	}
}
