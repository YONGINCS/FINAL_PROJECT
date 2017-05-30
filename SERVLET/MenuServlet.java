package final_Project_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import final_Project_Dao.MenuDAO;
import final_Project_Vo.MenuVO;

/**
 * 
 * @author AHN
 * Servlet implementation class MenuServlet
 */
@WebServlet("/Menu.do")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public MenuServlet(){
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServlet request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginsuccess.jsp");
		dispatcher.forward(request,response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = "menu.jsp";
		//String url1= "menu1.jsp";
	/*	String mn_date = request.getParameter("mn_date");
		String mn_name = request.getParameter("mn_name");
		int mn_price = Integer.parseInt(request.getParameter("mn_price"));
		String chain = request.getParameter("chain");
		String mn_type= request.getParameter("mn_type");
		
		MenuDAO mDao = MenuDAO.getInstance();
		int result = mDao.dateCheck(mn_date);
		*/
		MenuDAO mDao = MenuDAO.getInstance();
		List<MenuVO> menuInSungList = mDao.selectInSungMenu();
		request.setAttribute("menuInSungList", menuInSungList);
		
		List<MenuVO> menuHwanList= mDao.selectHwanMenu();
		request.setAttribute("menuHwanList", menuHwanList);
		
		List<MenuVO> menuDormList= mDao.selectDormMenu();
		request.setAttribute("menuDormMenu", menuDormList);
		
		
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	
	
	
		}
}
