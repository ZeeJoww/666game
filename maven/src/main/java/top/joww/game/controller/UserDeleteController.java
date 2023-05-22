package top.joww.game.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.joww.game.service.UserService;

@WebServlet("/userDelete")
public class UserDeleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean ret = userService.deleteUserById(id);
		
		if (ret) {
			request.setAttribute("info", "删除成功！");
			request.setAttribute("info_type", "success");
		} else {
			request.setAttribute("info", "删除失败！");
			request.setAttribute("info_type", "danger");
		}
		
		request.getRequestDispatcher("manage").forward(request, response);
	}
	
}
