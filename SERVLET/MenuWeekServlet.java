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
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		dispatcher.forward(request,response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = "menuweek.jsp";
		//String url1= "menu1.jsp";
	/*	String mn_date = request.getParameter("mn_date");
		String mn_name = request.getParameter("mn_name");
		int mn_price = Integer.parseInt(request.getParameter("mn_price"));
		String chain = request.getParameter("chain");
		String mn_type= request.getParameter("mn_type");
		
		MenuDAO mDao = MenuDAO.getInstance();
		int result = mDao.dateCheck(mn_date);
		*/
		MenuWeekDAO mDao = MenuWeekDAO.getInstance();
		List<MenuWeekVo> menuWeekList = mDao.selectWeekMenu();
		request.setAttribute("menuWeekList", menuWeekList);
		
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	
	
	
		}

}
