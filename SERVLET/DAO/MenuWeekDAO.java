package final_Project_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



import final_Project_Vo.MenuWeekVo;

public class MenuWeekDAO {
	
		private MenuWeekDAO(){
			
		}
		
		private static MenuWeekDAO instance = new MenuWeekDAO();
		
		public static MenuWeekDAO getInstance(){
			return instance;
		}
		public Connection getConnection() throws Exception{
			Connection conn = null;
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			return conn;
		}
	
public List<MenuWeekVo> selectWeekMenu(){
		
		String sql ="select * from menu order by mn_date ";
		List<MenuWeekVo> list = new ArrayList<MenuWeekVo>();
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
	
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
					
						MenuWeekVo mVoWeek = new MenuWeekVo();
						
						mVoWeek.setMn_date(rs.getString("mn_date"));
						mVoWeek.setChain(rs.getString("chain"));
						mVoWeek.setMn_type(rs.getString("mn_type"));
						mVoWeek.setMn_name(rs.getString("mn_name"));
						mVoWeek.setMn_price(rs.getInt("mn_price"));
						list.add(mVoWeek); // Arraylist에 객체 추가
					}
				 // while문 끝
		} catch(Exception e ){
			e.printStackTrace();
		} finally {
			try{
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
				
	}	
}
