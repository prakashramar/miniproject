package Forget;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;


@WebServlet("/Forg")
public class Forg extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String Fusername=request.getParameter("Fusername");
		String Fpassword=request.getParameter("Fpassword");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sri","root","Sriprakash@123");
		
			PreparedStatement s=con.prepareStatement("update login set password='"+Fpassword+"' where name='"+Fusername+"'");
			s.executeUpdate();
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


