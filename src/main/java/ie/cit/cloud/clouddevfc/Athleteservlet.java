package ie.cit.cloud.clouddevfc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class Athleteservlet extends HttpServlet {
	
	private WebApplicationContext ctx;

	@Override
	public void init() throws ServletException {
		ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Athleterepository athleteRepo = getAthleteRepo(req);
		req.setAttribute("athletes", athleteRepo.getAthletes());
		doForward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Athleterepository athleteRepo = getAthleteRepo(req);
		Athlete athlete = new Athlete();
		athlete.setFirstName(req.getParameter("firstName"));
		athlete.setSurname(req.getParameter("surname"));
		athleteRepo.addAthlete(athlete);

		req.setAttribute("athletes", athleteRepo.getAthletes());
		doForward(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer index = Integer.valueOf(req.getParameter("athleteId"));
		doForward(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer index = Integer.valueOf(req.getParameter("athleteId"));
		Athleterepository athleteRepo = getAthleteRepo(req);
		//athleteRepo.getAthletes().remove(index - 1);  
		req.setAttribute("todos", athleteRepo.getAthletes());
		doForward(req, resp);
	}

	private Athleterepository getAthleteRepo(HttpServletRequest req) {
		return ctx.getBean(Athleterepository.class);
	}

	private void doForward(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/signup.jsp");
		rd.forward(req, resp);
	}

}
