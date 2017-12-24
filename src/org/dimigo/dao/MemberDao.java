package org.dimigo.dao;

import java.rmi.server.ExportException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dimigo.vo.DashboardVO;
import org.dimigo.vo.MemberVO;
import org.dimigo.vo.UserVO;


public class MemberDao {
	private Connection conn = null;
	
	public MemberDao(Connection conn) {
		this.conn = conn;
	}

	public MemberVO getMemberId(MemberVO member) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "SELECT id from member WHERE user_id = ? and password = ?";

		try{
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,member.getUserId());
			pstmt.setString(2,member.getPassword());

			rs = pstmt.executeQuery();

			MemberVO result = null;

			if(rs.next()){
				result = new MemberVO();
				result.setId(rs.getInt(1));
			}

			return result;

		} catch(Exception e){
		 	e.printStackTrace();
		 	throw new Exception("아디 가져오기 실패");
		} finally{
			if(pstmt != null) pstmt.close();
		}

	}

	public void BasicSignUp(MemberVO member) throws Exception{
		PreparedStatement pstmt = null;
		String query = "INSERT INTO member(name,user_id,password,is_seller) VALUES(?,?,?,?)";

		try{
				pstmt = conn.prepareStatement(query);

				pstmt.setString(1,member.getName());
				pstmt.setString(2,member.getUserId());
				pstmt.setString(3,member.getPassword());
				pstmt.setBoolean(4,member.isSeller());

				int cnt = pstmt.executeUpdate();

				if(cnt == 0){
					throw new Exception("사용자 등록에 실패 했데요");
				}

		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("사용자 조회에 실패 했데요");
		} finally{
			if(pstmt != null) pstmt.close();
		}

	}

	public void DetailSignUp(MemberVO member) throws Exception{
		System.out.println("시작이다 세부 회원가입이..!");
		
		PreparedStatement pstmt = null;
		String query = "INSERT INTO member_light_info(member_id,profile_image,nickname,gender,phone,email) VALUES(?,?,?,?,?,?)";

		try{
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1,member.getId());
			pstmt.setString(2,member.getProfileImage());
			pstmt.setString(3,member.getNickname());
			pstmt.setString(4,member.getGender());
			pstmt.setInt(5,member.getPhone());
			pstmt.setString(6,member.getEmail());

			int cnt = pstmt.executeUpdate();

			if(cnt == 0){
				throw new Exception("세부 사용자 등록에 실패 했데요오오오오");
			}

		} catch(Exception e){
			e.printStackTrace();
			throw new Exception("세부 사용자 조회에 실패 했데용ㅇ");
		} finally{
			if(pstmt != null) pstmt.close();
		}
	}

	public void SellerSignUp(MemberVO member) throws Exception{
		PreparedStatement pstmt = null;
		String query = "INSERT INTO member_heavy_info(member_id,account) VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,member.getId());
			pstmt.setString(2, member.getAccount());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 0) {
				throw new Exception("판매사용자 등록에 실패 하였습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("판매사용자 조회에 실패 하였습니다.");
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}

	public void SignUpProfile(MemberVO member) throws Exception{
		PreparedStatement pstmt = null;
		String query = "INSERT INTO member_profile_info(member_id, profile_content) VALUES(?,?)";

		try{
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1,member.getId());
			pstmt.setString(2,member.getProfile_content());

			int cnt = pstmt.executeUpdate();

			if(cnt == 0){
				throw new Exception("프로필 내용 등록에 실패함");
			}

		} catch(Exception e){
			e.printStackTrace();
			throw new Exception("프로필 내용 조회에 실패했츰!");
		} finally{
			if(pstmt != null) pstmt.close();
		}

	}

	public MemberVO login(MemberVO member) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id FROM member WHERE user_id=? AND password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPassword());
			
			rs = pstmt.executeQuery();
			
			MemberVO result = null;
			
			if(rs.next()) {
				result = new MemberVO();
				result.setId(rs.getInt(1));
			}

			return result;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생했습니다.");
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}

	public MemberVO login_info(int member_id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member_light_info Where member_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, member_id);
			
			rs = pstmt.executeQuery();
			
			MemberVO result = null;
			List<MemberVO> list = new ArrayList<>();
			
			if(rs.next()) {
				result = new MemberVO();
				
				result.setId(rs.getInt(2));
				result.setProfileImage(rs.getString(3));
				result.setNickname(rs.getString(4));
			}
			
			return result;
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception("오유류류류ㅠ률");
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	
	public List<MemberVO> searchTop4List() throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT mli.profile_image, mli.nickname, mhi.earn, mpi.profile_content, mli.member_id FROM "
				+ "member_light_info As mli JOIN member_heavy_info AS mhi ON mli.member_id = mhi.member_id"
				+ " JOIN member_profile_info AS mpi ON mhi.member_id = mpi.member_id ORDER BY convert(mhi.earn,decimal) desc";
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			MemberVO result = null;
			List<MemberVO> list = new ArrayList<>();
			
			while (rs.next()) {
				result = new MemberVO();
				result.setProfileImage(rs.getString(1));
				result.setNickname(rs.getString(2));
				result.setEarn(rs.getString(3));
				result.setProfile_content(rs.getString(4));
				result.setId(rs.getInt(5));
				
				list.add(result);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 목록 조회 시 오류가 발생했습니다.");
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
		}
	}
	
	public MemberVO profileTab(MemberVO member) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT mi.name, mi.user_id, mi.password, mi.is_seller, "
				+ "mli.profile_image, mli.nickname, mli.gender, mli.phone, mli.email, "
				+ "mhi.account, mhi.earn, mpi.profile_content "
				+ "FROM member AS mi JOIN member_light_info AS mli ON mi.id = mli.member_id "
				+ "JOIN member_heavy_info AS mhi ON mli.member_id = mhi.member_id "
				+ "JOIN member_profile_info AS mpi ON mhi.member_id = mpi.member_id "
				+ "WHERE mi.id = ?";
		
		try {
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setInt(1, member.getId());
			 
			 rs = pstmt.executeQuery();
			 
			 MemberVO result = null;
			 while(rs.next()) {
				 result = new MemberVO();
				 
				 result.setName(rs.getString(1));
				 result.setUserId(rs.getString(2));
				 result.setPassword(rs.getString(3));
				 result.setSeller(rs.getBoolean(4));
				 
				 result.setProfileImage(rs.getString(5));
				 result.setNickname(rs.getString(6));
				 result.setGender(rs.getString(7));
				 result.setPhone(rs.getInt(8));
				 result.setEmail(rs.getString(9));
				 
				 result.setAccount(rs.getString(10));
				 result.setEarn(rs.getString(11));
				 
				 result.setProfile_content(rs.getString(12));
			 }
			 
			 return result;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("오롤오ㅗㄹ오로롤류!");
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
		}
	}
	
	public List<DashboardVO> getDashboard(MemberVO member) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM dashboard where member_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, member.getId());
			
			rs = pstmt.executeQuery();
			
			DashboardVO result = null;
			List<DashboardVO> list = new ArrayList<>();
			
			while(rs.next()) {
				result = new DashboardVO();
				result.setMember_id(rs.getInt(2));
				result.setContent(rs.getString(3));
				
				list.add(result);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 목록 조회 시 오류가 발생했습니다.");
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
		}	
	}
	
	public MemberVO redirect(MemberVO member) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member WHERE id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, member.getId());
			
			rs = pstmt.executeQuery();
			
			MemberVO result = null;
			
			if(rs.next()) {
				result = new MemberVO();
				result.setId(rs.getInt(1));
				result.setName(rs.getString(2));
				result.setUserId(rs.getString(3));
				result.setNickname(rs.getString(5));
				result.setProfileImage(rs.getString(6));
			}

			return result;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생했습니다.");
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	
	public List<DashboardVO> redirectDash(MemberVO member) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM dashboard where member_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, member.getId());
			
			rs = pstmt.executeQuery();
			
			DashboardVO result = null;
			List<DashboardVO> list = new ArrayList<>();
			
			while(rs.next()) {
				result = new DashboardVO();
				result.setMember_id(rs.getInt(2));
				result.setContent(rs.getString(3));
				
				list.add(result);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 목록 조회 시 오류가 발생했습니다.");
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
		}	
	}
	
}
