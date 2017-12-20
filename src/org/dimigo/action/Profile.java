package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Profile implements IAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		RequestDispatcher rd = req.getRequestDispatcher("jsp/my_profile.jsp");
		rd.forward(req, res);
	}

}
