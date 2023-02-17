package Login;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String lname=request.getParameter("lname");
		String lpassword=request.getParameter("lpassword");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sri","root","Sriprakash@123");
		//	Statement smt=con.createStatement();
						
			PreparedStatement ps=con.prepareStatement("select * from Login where name=? and password=?");
			ps.setString(1, lname);
			ps.setString(2, lpassword);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				response.sendRedirect("Home.jsp");
			}
			else
			{
				response.sendRedirect("Register.jsp");
			}	
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println(e);
		} 
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		
	}

	}


