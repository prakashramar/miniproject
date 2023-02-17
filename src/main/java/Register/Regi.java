package Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;


@WebServlet("/Regi")
public class Regi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String Rname=request.getParameter("Rname");
		String Rpassword=request.getParameter("Rpassword");
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sri","root","Sriprakash@123");
			Statement smt=con.createStatement();
			
			String s="insert into login (name,password) values ('"+Rname+"','"+Rpassword+"')";
						
			PreparedStatement ps=con.prepareStatement(s);
			ps.executeUpdate();
			
			response.sendRedirect("Loginpage.jsp");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}	
	}


	}


