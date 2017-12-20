package org.dimigo.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.DashboardService;
import org.dimigo.vo.DashboardVO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DashboardSaveAction implements IAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		PrintWriter out = res.getWriter();
		
		try {
			req.setCharacterEncoding("utf-8");
			res.setContentType("application/json;charset=utf-8");
			int member_id = Integer.parseInt(req.getParameter("id"));
			String content = req.getParameter("content");
			
			System.out.println("--- DashboardSaveAction ---");
			System.out.println(member_id);
			System.out.println(content);
			
			DashboardVO dashboard = new DashboardVO();
			
			dashboard.setMember_id(member_id);
			dashboard.setContent(content);
			
			DashboardService service = new DashboardService();
			
			service.mkUI(dashboard);
			
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
