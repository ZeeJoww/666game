package top.joww.game.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String keywords = request.getParameter("inputKeywords");
        String msg = null;

    	if (msg != null) {
    		request.getSession().setAttribute("info", msg);
            request.getRequestDispatcher("register.jsp").forward(request, response);
    	} else {
    		response.sendRedirect("index.jsp");
    	}
    }
}
