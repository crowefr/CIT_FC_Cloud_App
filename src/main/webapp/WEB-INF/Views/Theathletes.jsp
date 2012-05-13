<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Athletics</title>
<link href="styles/style.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>
	<div id="wrapper">
		<div id="header-wrapper">
			<div id="header">
				<div id="logo">
					<h1>Athletics</h1>
					<p>
						London Olympics</a>
					</p>
				</div>
			</div>
		</div>
		<!-- end #header -->
		<div id="menu">
			<ul>
				<li><a href="index.html">Home</a></li>
				<li class="current_page_item"><a href="#">Sign Up</a></li>
				<li><a href="theathletes.html">Athletics</a></li>
				<li><a href="events.html">Events</a></li>
				<li><a href="athleteprofile.html">Athlete Profile</a></li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="page">
					<div id="content">
						<div class="post">
							<h2 class="title">
								<a href="#">Sign Up </a>
							</h2>
							<div class="entry">
								<h3>List of Athlets</h3>
								<table border="1" bordercolor="#999393" style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3"><th>First Name</th><th>Surname</th><th>Country</th><th>Event</th>
								<c:forEach items="${athletes}" var="athlete" varStatus="row">
			 					<tr><td> ${athlete.firstName} </td><td> ${athlete.surname} </td><td> ${athlete.country} </td><td> ${athlete.event} </td></tr> 
								</c:forEach>
								</table>
								<br />
								<h3>Sign Up Form</h3>
								<form method="post"><table style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3">
									<tr><td><b>Username: </b></td><td><input name="username"></td></tr> 
									<tr><td><b>Password: </b></td><td><input type="password" name="password"></td></tr>
									<tr><td><b>First Name: </b></td><td><input name="firstName"></td></tr> 
									<tr><td><b>Surname: </b></td><td><input name="surname"></td></tr>
									<tr><td><b>Country: </b></td><td><input name="country"></td></tr>
									</table>
									<input type="submit">									
								</form>
							</div>
						</div>
						<div style="clear: both;">&nbsp;</div>
					</div>
					<!-- end #content -->
					<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #page -->

		<div id="footer">
		<!-- end #footer -->
	</div>
</body>
</html>