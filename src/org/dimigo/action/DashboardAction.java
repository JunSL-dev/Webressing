package org.dimigo.action;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DashboardAction implements IAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		PrintWriter out = res.getWriter();
		
		try {
			req.setCharacterEncoding("utf-8");
			res.setContentType("application/json;charset=utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
		
			req.getServletContext().setAttribute("id", id);
			
			System.out.println("Something good");
			
			obj.addProperty("success", true);
			out.write(gson.toJson(obj));
			out.close();
		} catch(Exception e) {
			obj.addProperty("fail", true);
			out.write(gson.toJson(obj));
			out.close();
			System.out.println("Something wrong");
		}
	}

}
