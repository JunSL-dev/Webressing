package org.dimigo.service;

import java.sql.Connection;
import java.util.List;

import org.dimigo.dao.MemberDao;
import org.dimigo.dao.UserDao;
import org.dimigo.vo.DashboardVO;
import org.dimigo.vo.MemberVO;
public class MemberService extends AbstractService{

	public MemberVO getMemberId(MemberVO member) throws Exception{
		Connection conn = null;

		try {
			conn = getConnection();

			MemberDao dao = new MemberDao(conn);

			return dao.getMemberId(member);

		} finally {
			if(conn != null) conn.close();
		}
	}
	
	public MemberVO profileTab(MemberVO member) throws Exception{
		Connection conn = null;

		try {
			conn = getConnection();

			MemberDao dao = new MemberDao(conn);

			return dao.profileTab(member);

		} finally {
			if(conn != null) conn.close();
		}
	}
	
	public void signUp(MemberVO member) throws Exception{
		System.out.println("여기는 memberService!");
		
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			MemberDao dao = new MemberDao(conn);
			
			System.out.println("판매자 여부: "+member.isSeller());
						
			if(member.isSeller()) {
				System.out.println("판매자입니다.");
				dao.BasicSignUp(member);
				member.setId(dao.getMemberId(member).getId());
				dao.DetailSignUp(member);
				dao.SellerSignUp(member);
				dao.SignUpProfile(member);
			} else {
				System.out.println("일반 회원입니다.");
				dao.BasicSignUp(member);
				member.setId(dao.getMemberId(member).getId());
				dao.DetailSignUp(member);
				dao.SignUpProfile(member);
			}
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	
	public MemberVO login(MemberVO member) throws Exception{
		Connection conn = null;
		try {
			conn = getConnection();
			
			MemberDao dao = new MemberDao(conn);
			MemberVO result = dao.login(member);
			
			if(result == null) {
				throw new Exception("Invalid id or password!");
			}
			return result;
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	
	public MemberVO login_info(int member_id) throws Exception{
		Connection conn = null;
		try {
			conn = getConnection();
			
			MemberDao dao = new MemberDao(conn);
			
			return dao.login_info(member_id);
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	
	public List<MemberVO> get_top4() throws Exception {
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			MemberDao dao = new MemberDao(conn);
			
			return dao.searchTop4List();
		} finally {
			if (conn != null) conn.close();
		}
	}
	
	public List<DashboardVO> getDashboard(MemberVO member) throws Exception{
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			MemberDao dao = new MemberDao(conn);
			
			return dao.getDashboard(member);
		} finally {
			if (conn != null) conn.close();
		}
	}
	
	public MemberVO redirect(MemberVO member) throws Exception{
		Connection conn = null;
		try {
			conn = getConnection();
			
			MemberDao dao = new MemberDao(conn);
			MemberVO result = dao.redirect(member);
			
			if(result == null) {
				throw new Exception("Invalid id or password!");
			}
			return result;
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	public List<DashboardVO> redirectDash(MemberVO member) throws Exception{
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			MemberDao dao = new MemberDao(conn);
			
			return dao.redirectDash(member);
		} finally {
			if (conn != null) conn.close();
		}
	}
	
}
