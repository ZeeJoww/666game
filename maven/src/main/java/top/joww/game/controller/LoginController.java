package top.joww.game.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.joww.game.entity.Login;
import top.joww.game.service.LoginService;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");
        
        Login login = new Login(username, "", password, "");
        LoginService service = new LoginService();
        String msg = service.loginAction(login);

    	if (null != msg) {
    		request.getSession().setAttribute("info", msg);
            request.getRequestDispatcher("login.jsp").forward(request, response);
    	} else {
    		response.addCookie(new Cookie("id", Long.toString(login.getId())));
    		response.addCookie(new Cookie("nickname", login.getNickname()));
    		response.sendRedirect("index.jsp");
    	}
    }
}
