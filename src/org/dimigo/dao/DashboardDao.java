package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.dimigo.vo.DashboardVO;

public class DashboardDao {
	private Connection conn = null;
		
	public DashboardDao(Connection conn) {
		this.conn = conn;
	}
		
	public void mkUI(DashboardVO dashboard) throws Exception{
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO dashboard(member_id,content) VALUES(?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dashboard.getMember_id());
			pstmt.setString(2, dashboard.getContent());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(" 정보 입력 실패! ");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
	
}
