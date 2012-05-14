<html>
<head>
<link rel="stylesheet" href="styles/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<div id="head">
		<h1>
			<b>Enter Your Username, Password, and e-mail </b>
		</h1>
		<p><%=new java.util.Date()%></p>
	</div>
	<div id="menu">
		<table align="center" cellpadding="5">
			<tr>
				<td><a href="main.jsp">Home</a></td>
				<td><a href="users.jsp">Search</a></td>
			</tr>
		</table>
	</div>
	
		<h2>Enter Your Details</h2>
		<form method="post">
		<table>
				<tr>
					<td>Firstame:</td>
					<td><input name="firstName"></td>
				</tr>
				<tr>
					<td>Surname:</td>
					<td><input name="surname"></td>
				</tr>
				<tr>
					<td>e-mail:</td>
					<td><input name="email"></td>
				</tr>
				<tr>
					<td><input type="submit"></td>
				</tr>
		</table>
		</form>
	<div id="form">
		
			
			
			
			<table border=4>
				<tr>
					<td>First Name</td>
					<td>Surname</td>
					<td>e-mail</td>
				</tr>
				<tr>
					<td>Joe</td>
					<td>Bloggs</td>
					<td>joe@spring.ie</td>
				</tr>
			</table>
			
			
		
			
			
			
			<table border=4>
				<tr>
					<td>Mary</td>
					<td>Bloggs</td>
					<td>mary@spring.ie</td>
				</tr>
				<tr>
					<td>Tom</td>
					<td>Jones</td>
					<td>Tom@spring.ie</td>
				</tr>
			</table>
			
			
		
		</div>

<div id="footer">
	
	
	</div>
</body>
</html>