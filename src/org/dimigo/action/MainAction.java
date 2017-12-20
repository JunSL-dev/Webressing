package org.dimigo.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.MemberService;
import org.dimigo.vo.MemberVO;

public class MainAction implements IAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		
		List<MemberVO> member;
		MemberService service = new MemberService();
		
		member = service.get_top4();
		
		req.setAttribute("data", member);
		
		RequestDispatcher rd = req.getRequestDispatcher("jsp/main.jsp");
		rd.forward(req, res);
	}
	
}
