<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
			</div>
		</div>
		<!-- end #header -->
		<div id="menu">
			<ul>
				<li><a href="index.html">Home</a></li>
				<li><a href="signup.html">Sign Up</a></li>
				<li><a href="theathletes.html">Athletes</a></li>
				<li><a href="events.html">Events</a></li>
				<li class="current_page_item"><a href="athleteprofile.html">Athlete Profile</a></li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="page">
					<div id="content">
						</br><b><a href="j_spring_security_logout">LOGOUT: <security:authentication
						property="principal.username" /></a></b>
						<div class="post">
							<h2 class="title">
								<a href="#">Athlete Profile </a>
							</h2>
							<div class="entry">
								<h3>Your Profile</h3>
								<p>Update your profile.</p>
								<form method="post"><table style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3">
									<input name="_method" type="hidden" value="put"> <input name="athleteId" type="hidden" value="${athlete.id}"> 
									<tr><td><b>Username: </b></td><td>${athlete.username}</td></tr> 
									<tr><td><b>First Name: </b></td><td><input name="firstName" value="${athlete.firstName}"></td></tr> 
									<tr><td><b>Surname: </b></td><td><input name="surname" value="${athlete.surname}"></td></tr>
									<tr><td><b>Country: </b></td><td><input name="country" value="${athlete.country}"></td></tr>
									</table>
									<input type="submit" value="Update Profile">									
								</form>
							</div>
						</div>
						<div style="clear: both;">&nbsp;</div>
					</div>
					<!-- end #content -->
					<div style="clear: both;">&nbsp;</div>
		</div>
	</div>
</body>
</html>