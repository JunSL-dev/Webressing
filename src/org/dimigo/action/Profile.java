package org.dimigo.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.DashboardService;
import org.dimigo.service.MemberService;
import org.dimigo.vo.DashboardVO;
import org.dimigo.vo.MemberVO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Profile implements IAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		PrintWriter out = res.getWriter();
		try {
			req.setCharacterEncoding("utf-8");
			res.setContentType("application/json;charset=utf-8");
			
			int id = Integer.parseInt(req.getParameter("id")); 
			String whichFunc = req.getParameter("whichFunc");
			
			MemberVO member = new MemberVO();
			member.setId(id);
						
			MemberService service = new MemberService();
			MemberVO result = service.profileTab(member);
			
			DashboardService dashboard_service = new DashboardService();
			List<DashboardVO> dashboard = dashboard_service.getDashboard(member);
			
			for(DashboardVO dash : dashboard) {
				System.out.println("-------------Check--------------");
				System.out.println(dash.getContent());
			}
			
			req.getServletContext().setAttribute("result",result);
			req.getServletContext().setAttribute("whichFunc", whichFunc);
			req.getServletContext().setAttribute("dashboard", dashboard);
						
			obj.addProperty("success", true);
			out.write(gson.toJson(obj));
			out.close();
			
		} catch(Exception e) {
			obj.addProperty("fail", true);
			out.write(gson.toJson(obj));
			out.close();
		}
		
		
	}

}
