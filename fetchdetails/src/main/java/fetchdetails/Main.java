package fetchdetails;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Main"
		+ "")
public class Main extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String tempopt=req.getParameter("opt");
	int option=Integer.parseInt(tempopt);
	PrintWriter pw=resp.getWriter();
	switch(option)
	{
	case 1:
		RequestDispatcher r=req.getRequestDispatcher("FetchAll.html");
		r.include(req,resp);
		break;
	case 2:
		RequestDispatcher R=req.getRequestDispatcher("fetch.html");
		R.include(req,resp);
		break;
		default:
			pw.println("enter vaild option");
			break;
	}
}
}
