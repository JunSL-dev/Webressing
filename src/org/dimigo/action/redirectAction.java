package org.dimigo.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.MemberService;
import org.dimigo.vo.DashboardVO;
import org.dimigo.vo.MemberVO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class redirectAction implements IAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		PrintWriter out = res.getWriter();
		
		try {
			req.setCharacterEncoding("utf-8");
			res.setContentType("application/json;charset=utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
			String view = req.getParameter("view");
			
			System.out.println(view);

			
			MemberVO member = new MemberVO();
			member.setId(id);
			
			// 멤버 서비스로 갑니다!
			MemberService service = new MemberService();
			MemberVO result = service.redirect(member);
									
			System.out.println("확인 요망: "+result.getId());
			
			List<DashboardVO> dashboard_result = service.redirectDash(member);
			
			HttpSession session = req.getSession();
			session.setAttribute("user", result);
			session.setAttribute("dashboards", dashboard_result);
			if(view != null) {
				session.setAttribute("view", true);
			}
			
			obj.addProperty("success", true);
			out.write(gson.toJson(obj));
			out.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			obj.addProperty("error", true);
			out.write(gson.toJson(obj));
			out.close();
		}
	}

}
