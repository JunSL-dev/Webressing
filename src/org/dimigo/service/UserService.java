package org.dimigo.service;

import java.sql.Connection;
import java.util.List;

import org.dimigo.dao.UserDao;
import org.dimigo.vo.MemberVO;
import org.dimigo.vo.UserVO;

public class UserService extends AbstractService {
	
	public void signUp(MemberVO member) throws Exception{
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
		} finally {
			if(conn != null) conn.close();
		}
	}

	public UserVO login(UserVO user) throws Exception {
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			UserVO result = dao.searchUser(user);
			
			if (result == null) throw new Exception("Invalid Username or Password");
			
			return result;
		} finally {
			if (conn != null) conn.close();
		}
	}
	
	public List<UserVO> searchUserList() throws Exception {
		// DB에서 사용자 목록 조회
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			return dao.searchUserList();
		} finally {
			if (conn != null) conn.close();
		}
	}
	
	public void signup(UserVO user) throws Exception {
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			// 사용중인 아이디인지 체크
			UserVO result = dao.searchUserById(user);
			
			if (result != null) throw new Exception("이미 사용중인 아이디입니다.");
			
			// 사용자 등록
			dao.insertUser(user);
			
		} finally {
			if (conn != null) conn.close();
		}
	}
}
