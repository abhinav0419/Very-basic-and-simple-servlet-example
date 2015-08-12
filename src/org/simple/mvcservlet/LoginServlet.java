package org.simple.mvcservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simple.mvcservlet.dto.User;
import org.simple.mvcservlet.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId,password;
		userId=request.getParameter("userId");
		password=request.getParameter("password");
		LoginService service=new LoginService();
		boolean result=service.authenticate(userId, password);
		if(result){
			User user=service.getUserDetails(userId);
			request.setAttribute("user", user);
			//response.sendRedirect("success.jsp");// when we use response it means a new request is done by the browser to return the specifie jsp
			RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");// While using the request dispatcher it means we use the same request and no new request is made by the browser thus we use req and res.
			dispatcher.forward(request,response);// this means it will do a forward to the success jsp page.
			return;
		}
		response.sendRedirect("login.jsp");
		return;
	}

}
