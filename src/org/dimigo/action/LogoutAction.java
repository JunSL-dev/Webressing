package org.dimigo.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.MemberService;
import org.dimigo.vo.MemberVO;

public class LogoutAction implements IAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		
		List<MemberVO> member;
		MemberService service = new MemberService();
		
		member = service.get_top4();
		
		req.setAttribute("data", member);
		// 세션에 사용자 정보 삭제
		HttpSession session = req.getSession();
				
		session.invalidate();
				
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/main.jsp");
		rd.forward(req, res);
	}

}
