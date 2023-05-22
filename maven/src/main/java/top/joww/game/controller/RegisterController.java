package top.joww.game.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.joww.game.entity.Login;
import top.joww.game.service.RegisterService;

import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("inputUsername");
        String nickname = request.getParameter("inputNickname");
        String password = request.getParameter("inputPassword");
        String passwordAgain = request.getParameter("inputPasswordAgain");
        String email = request.getParameter("inputEmail");
        String veriCode = request.getParameter("inputVerificationCode");
        
        Login login = new Login(username, nickname, password, email);
        RegisterService service = new RegisterService();
        String msg = service.registerAction(login, passwordAgain, veriCode);

    	if (msg != null) {
    		request.getSession().setAttribute("info", msg);
            request.getRequestDispatcher("register.jsp").forward(request, response);
    	} else {
    		response.addCookie(new Cookie("id", Long.toString(login.getId())));
    		response.addCookie(new Cookie("nickname", login.getNickname()));
    		response.sendRedirect("index.jsp");
    	}
    }
}
