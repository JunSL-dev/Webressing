package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dimigo.vo.DashboardVO;
import org.dimigo.vo.MemberVO;

public class DashboardDao {
	private Connection conn = null;
		
	public DashboardDao(Connection conn) {
		this.conn = conn;
	}
		
	public void mkUI(DashboardVO dashboard) throws Exception{
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO layout(member_id,layouts) VALUES(?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dashboard.getMember_id());
			pstmt.setString(2, dashboard.getContent());
			
			System.out.println("yeah seucsd");
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(" 정보 입력 실패! ");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
	
	public List<DashboardVO> getDashboard(MemberVO member) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM layout WHERE member_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,member.getId());
			
			System.out.println("yeah seucsd");
			
			rs = pstmt.executeQuery();
			
			DashboardVO result = null;
			List<DashboardVO> list = new ArrayList<>();
			
			while(rs.next()) {
				result = new DashboardVO();
				result.setMember_id(rs.getInt(2));
				result.setContent(rs.getString(3));
				result.setSeller(rs.getBoolean(4));
				
				list.add(result);
			}
			
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(" 정보 입력 실패! ");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}
	
}
