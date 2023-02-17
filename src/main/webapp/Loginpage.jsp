<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="Login">
		<table>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="lpassword"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
			<tr>
				<td><button>
						<a href="Register.jsp">Register</a>
					</button>
				</td>
				<td><button>
					<a href="Forget.jsp">Forget</a>
					</button>
				</td>
			</tr>

		</table>

	</form>



</body>
</html>