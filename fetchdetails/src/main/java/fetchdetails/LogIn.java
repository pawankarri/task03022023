package fetchdetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LogIn")	
	public class LogIn extends HttpServlet
	{
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            
	           out.println("<html><body>");
	            out.println("<h3>Fetching Details</h3>");
	            out.println("<table border=1><tr>" + "<td><b>FirstName</b></td>" + "<td><b>LastName</b></td>"
	                    + "<td><b>E-mail</b></td>" + "<td><b>Phone-Number</b></td>"
	                    + "<td><b>DOB</b></td>" + "<td><b>Passwd</b></td></tr>");
			String email=request.getParameter("email");
			String passwd=request.getParameter("passwd");
			String url="jdbc:mysql://localhost:3306?user=root&password=12345";
			String query="select * from pawan.register where Email=? and Password=?";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url);
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,email);
				ps.setString(2,passwd);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String name=rs.getString(1);
					String lastname=rs.getString(2);
					String Email=rs.getString(3);
					String phone=rs.getString(4);
					String dob=rs.getString(5);
					String passwdd=rs.getString(6);
					
					
					out.println("<tr>" + "<td>" + name + "</td>" + "<td>" + lastname + "</td>" + "<td>" + Email + "</td>"
	                        + "<td>" + phone + "</td>" + "<td>" + dob + "</td>" + "<td>" + passwdd
	                        + "</td></tr>");
				}
				out.println("</table></body></html>");
				 rs.close();
		            ps.close();
		            out.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
			


