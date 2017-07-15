package final_Project_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import final_Project_Vo.ForuseVO;
import final_Project_Vo.MenuRcgVO;
import final_Project_Vo.StudentVO;

public class ForuseDAO {
	
	private ForuseDAO(){}
	
	private static ForuseDAO instance = new ForuseDAO();

	public static ForuseDAO getInstance(){
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
	public String login(HttpServletRequest request)
	{
		
		HttpSession session  =request.getSession();
		String stu_id = (String)session.getAttribute("stu_id");
		
		
		return stu_id;
	}
	
	public int getForuse(ForuseVO fVo)
	{
		int result = -1;
		//chain, mn_name 은 후에 다시 수
		//빼기 조
		String sql = "insert into foruse(stu_id, date, mn_price, f_use) values (?, ?, 3500, 'use') ";
		String sql2= "update student set stu_change = stu_change - 3500  where stu_id = ? ";
		
		
		Connection conn = null;
		
		PreparedStatement pstmt =null;
		PreparedStatement pstmt1 = null;
		
		
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		
		
	
		/*
		StudentDAO sDao= new StudentDAO();
		StudentVO sVo = new StudentVO();
		
		
		String b= sVo.getStu_id();
		String c= fVo.getStu_id();
		b=c;
		
		*/
		
		
		try{
			
			
			conn = getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt1 = conn.prepareStatement(sql2);
			
			pstmt.setString(1, "201233022");
			pstmt.setString(2, a);
			
			pstmt1.setString(1, "201233022");
			
			result = pstmt.executeUpdate();
			result = pstmt1.executeUpdate();
			
			conn.commit();
			
		}catch(Exception e)
		{
			try{
				conn.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
			return result;
			//result -> result 1 로 수
		
	}
	
}
