package top.joww.game.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.joww.game.entity.Login;
import top.joww.game.dao.impl.LoginDaoImpl;

import java.io.IOException;

@WebServlet("/message")
public class MessageController extends HttpServlet {
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
        
        if (true == username.equals("")) { 
            request.getSession().setAttribute("info", "用户名不能为空");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (true == password.equals("")) { 
            request.getSession().setAttribute("info", "密码不能为空");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
        	LoginDaoImpl dao = new LoginDaoImpl();
            Login login = null;
            String msg = dao.checkAndGetLogin(login);
    		response.sendRedirect("index.jsp");
    		return;
//        	if (false == msg.equals("")) {
//        		request.getSession().setAttribute("info", msg);
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//        	} else {
//        		response.sendRedirect("index.jsp");
//        	}
        }
    }
}
