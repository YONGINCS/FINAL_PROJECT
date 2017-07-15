package final_Project_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import final_Project_Dao.MenuDAO;
import final_Project_Dao.MenuWeekDAO;
import final_Project_Vo.MenuVO;
import final_Project_Vo.MenuWeekVo;

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
		RequestDispatcher dispatcher = request.getRequestDispatcher("Menu.do");
		dispatcher.forward( request,response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//String url = "menu3.jsp";
		String url= "menu_session.jsp";
		MenuWeekDAO wDao= MenuWeekDAO.getInstance();
		MenuDAO mDao = MenuDAO.getInstance();
		List<MenuVO> menuInSungList = mDao.selectInSungMenu();
		List<MenuVO> menuHwanList= mDao.selectHwanMenu();
		List<MenuVO> menuDormList= mDao.selectDormMenu();
		List<MenuWeekVo> menuWeekList = wDao.selectWeekMenu();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("menuInSungList", menuInSungList);
		session.setAttribute("menuHwanList", menuHwanList);
		session.setAttribute("menuDormList", menuDormList);
		session.setAttribute("menuWeekList", menuWeekList);
		
		request.setAttribute("menuInSungList", menuInSungList);
		request.setAttribute("menuHwanList", menuHwanList);
		request.setAttribute("menuDormList", menuDormList);
		request.setAttribute("menuWeekList", menuWeekList);
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);

		}
}
