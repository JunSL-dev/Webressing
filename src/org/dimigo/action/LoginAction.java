package org.dimigo.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.MemberService;
import org.dimigo.vo.DashboardVO;
import org.dimigo.vo.MemberVO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LoginAction implements IAction{

	// 저는 로그인입니다.
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		PrintWriter out = res.getWriter();
		
		try {
			
			System.out.println("---- LoginAction ----");
			
			// 일단 아뒤와 비번을 받죠
			req.setCharacterEncoding("utf-8");
			res.setContentType("application/json;charset=utf-8");

			String userId = req.getParameter("userId");
			String password = req.getParameter("password");
			
			// 제대로 왔나 체크
			System.out.println("사용자 아이디: "+userId);
			System.out.println("비밀번호: "+password);
			
			// 이제 멤버VO? 거기에다 UserId 와 Password를 넣고 최종적으로 MemberDao 에서 일치하는 정보가 있는지 확인합니당
			MemberVO member = new MemberVO();
			member.setUserId(userId);
			member.setPassword(password);
			
			// 멤버 서비스로 갑니다!
			MemberService service = new MemberService();
			MemberVO result = service.login(member);
			
			int id = result.getId();
						
			System.out.println("확인 요망: "+id);
						
			MemberVO info = service.login_info(id);
			
			HttpSession session = req.getSession();
			session.setAttribute("user", info);
						
			System.out.println("나는 성공 로그인 되어랏!");
			
			obj.addProperty("success", true);
			out.write(gson.toJson(obj));
			out.close();
			
		} catch(Exception e) {
			System.out.println("나는 에러 로그인 실패닷");
			obj.addProperty("error", true);
			out.write(gson.toJson(obj));
			out.close();
		}
		
	}

}
