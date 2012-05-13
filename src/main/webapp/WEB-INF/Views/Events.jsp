<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<div id="header-wrapper">
		<div id="header">
			<div id="logo">
				<p>London Olympics</a></p>
			</div>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="index.html">Home</a></li>
			<li><a href="signup.html">Sign Up</a></li>
			<li><a href="theathletess.html">Athletes</a></li>
			<li class="current_page_item"><a href="#">Events</a></li>
			<li><a href="athleteprofile.html">Athlete Profile</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page">
				<div id="content">
				</br><b><a href="j_spring_security_logout">LOGOUT: <security:authentication
						property="principal.username" /></a></b>
					<div class="post">
						<h2 class="title"><a href="#">Eventss </a></h2>
						<div class="entry">
						<h3>Create Event</h3>
						<form method="post"><table style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3">
							<tr><td><b>Date: </b></td><td><input name="date"></td></tr> 
							<tr><td><b>Venue: </b></td><td><input name="venue"></td></tr>
							<input name="winner" type="hidden" value="N/A">
							</table>
							<input type="submit">									
						</form>	
						</div>
						<div class="entry">
						<h3>Set Winner</h3>
							<table border="1" bordercolor="#999393" style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3"><th>Event Id</th><th>Date</th><th>Venue</th><th>Winner</th><th>Update</th>
							<c:forEach items="${events}" var="event" varStatus="row">
		 					<c:if test="${event.winner eq 'N/A'}">
		 					<form method="post">
		 					<input name="_method" type="hidden" value="put"> <input name="eventId" type="hidden" value="${event.id}"> 
		 					<tr><td> ${event.id} </td><td> ${event.date} </td><td> ${event.venue} </td><td> <input name="winner"></td><td><input type="submit" value="Update"></td></tr> 
							</form>
							</c:if>
							</c:forEach>
							</table>								
						</div>
						<div class="entry">
						<h3>Upcoming events</h3>
						<table border="1" bordercolor="#999393" style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3"><th>Event No.</th><th>Date</th><th>Venue</th>
						<c:forEach items="${events}" var="event" varStatus="row">
	 					<c:if test="${event.winner eq 'N/A'}">
	 					<tr><td> ${event.id} </td><td> ${event.date} </td><td> ${event.venue} </td></tr>
	 					</c:if>
	 					</c:forEach>
						</table>				
						</div>
					<div style="clear: both;">&nbsp;</div>
				</div>
				<!-- end #content -->
				<div style="clear: both;">&nbsp;</div>

	</div>
	<!-- end #page -->
</div>
</body>
</html>