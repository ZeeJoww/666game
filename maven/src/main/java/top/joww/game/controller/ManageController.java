package top.joww.game.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.joww.game.service.UserService;
import top.joww.game.service.GameService;
import top.joww.game.entity.Login;
import top.joww.game.entity.Game;

import java.util.List;
import java.io.IOException;

@WebServlet("/manage")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserService();
	GameService gameService = new GameService();

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Login> userList = userService.getUserList(0, 5); // 获取用户列表
    	List<Game> gameList = gameService.getGameList(0, 5); // 获取游戏列表
    	
		request.setAttribute("userList", userList);
		request.setAttribute("gameList", gameList);
		request.getRequestDispatcher("admin-page.jsp").forward(request, response);
    }
}
