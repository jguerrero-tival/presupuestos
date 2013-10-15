<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Presupuestar Login</title>
</head>
<body>
	<h2>Register Person Account</h2>
	<form:form method="post" action="registerPersonAccount.html">
		<table>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="firstname">First Name</form:label></td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">Last Name</form:label></td>
				<td><form:input path="lastname" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>