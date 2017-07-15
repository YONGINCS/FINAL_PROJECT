package final_Project_Dao;
//String radioValue = request.getParameter("밸류값이름")
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;

import final_Project_Servlet.LoginServlet;
import final_Project_Vo.MenuRcgVO;
import final_Project_Vo.StudentVO;

public class MenuRcgDAO {
	
	public class getCalender{
		public String cc(){
			
			Date d = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String a = df.format(d);
			return a;
		}
	}
	
	private MenuRcgDAO(){
			
		}
	
	private static MenuRcgDAO instance = new MenuRcgDAO();
	
	public static MenuRcgDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		
		conn = ds.getConnection();
		return conn;
	}
	
	
	//버튼눌럿을때 value값 받아오기 
	//해당 로그인 아이디와 리차지테이블 조인
	
	//스튜던트 테이블의 잔액과 밸류값을 더하고
	//그런 다음에 해당 로그인 잔액 추가됨.
	
	//1000원을 라디오 버튼으로 설정했을
	
	/*public int getStudentId(String stu_id)
	{
		String sql = "select stu_id from student where stu_id=?";
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		try{
			conn =getConnection();
			pstmt = conn.prepareStatement(sql);
		}
	
	}
	*/
	public int getValueRecharge_mn(MenuRcgVO mRVo) 
	{
		
		
		int result =-1;
		int result2 = -1;
		
		String sql = "INSERT INTO recharge(stu_id, date, recharge_mn) VALUES (?,?,?)";
		String sql2 = "UPDATE student SET stu_change = stu_change + ?  where stu_id = ?";
		
		String sql3 = "INSERT INTO foruse(stu_id, date, mn_price, f_use) VALUES (?, ?, ?, 'recharge')";
		
		
		Connection conn =null;
		PreparedStatement pstmt =null;
		PreparedStatement pstmt1 =null;
		PreparedStatement pstmt2= null;
		
		//날짜 
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		
		
		
		StudentVO sVo =new StudentVO();
		String b= sVo.getStu_id();
		String c= mRVo.getStu_id();
		b=c;
		
	
		 
		try{
			conn = getConnection();
			conn.setAutoCommit(false);
			
			
			pstmt= conn.prepareStatement(sql);
			pstmt1= conn.prepareStatement(sql2);
			pstmt2= conn.prepareStatement(sql3);
			
			
			pstmt.setString(1, b);
		    pstmt.setString(2, a);
		    pstmt.setInt(3, mRVo.getRecharge_mn());
				
			pstmt1.setInt(1, mRVo.getRecharge_mn());
			pstmt1.setString(2, b);
			
			pstmt2.setString(1, b);
			pstmt2.setString(2, a);
			pstmt2.setInt(3,mRVo.getRecharge_mn());
			
			result = pstmt.executeUpdate();
			result = pstmt1.executeUpdate();
			result = pstmt2.executeUpdate();
			
			conn.commit();
			
		}catch(Exception e)
		{	
			try{
				conn.rollback();
			}catch(SQLException e1){
				e.printStackTrace();
			}
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
			return result;
	}
}

