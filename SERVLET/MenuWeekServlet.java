package final_Project_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import final_Project_Dao.MenuWeekDAO;
import final_Project_Vo.MenuWeekVo;

/**
 * 
 * @author AHN
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuWeek.do")
public class MenuWeekServlet extends HttpServlet{
private static final long serialVersionUID=1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public MenuWeekServlet(){
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServlet request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu_session.jsp");
		dispatcher.forward(request,response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = "menuweek.jsp";
		String url2 = "admin_Menu_Week.jsp";

		MenuWeekDAO mDao = MenuWeekDAO.getInstance();
		List<MenuWeekVo> menuWeekList = mDao.selectWeekMenu();
		request.setAttribute("menuWeekList", menuWeekList);
		
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	
		}

}
