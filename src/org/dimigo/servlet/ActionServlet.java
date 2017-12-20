package org.dimigo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.DashboardAction;
import org.dimigo.action.DashboardSaveAction;
import org.dimigo.action.IAction;
import org.dimigo.action.LoginAction;
import org.dimigo.action.LogoutAction;
import org.dimigo.action.MainAction;
import org.dimigo.action.Profile;
import org.dimigo.action.SignUpAction;
import org.dimigo.action.redirectAction;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.run")
@MultipartConfig
public class ActionServlet extends HttpServlet {
	private Map<String,IAction> actions = new HashMap<>();
	
	private static final long serialVersionUID = 1L;

    public ActionServlet() {
        super();
    }
    
	public void init() throws ServletException {
		actions.put("main",new MainAction());
		actions.put("signup",new SignUpAction());
		actions.put("login", new LoginAction());
		actions.put("dashboard", new DashboardAction());
		actions.put("dashboardsave", new DashboardSaveAction());
		actions.put("logout", new LogoutAction());
		actions.put("redirect", new redirectAction());
		actions.put("profile", new Profile());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

    protected void process(HttpServletRequest req, HttpServletResponse res) {
    		try {
    			String uri = req.getRequestURI();
    			String actionName = uri.substring(uri.lastIndexOf("/") + 1);
    			actionName = actionName.substring(0,actionName.indexOf('.'));
    			
    			IAction action = actions.get(actionName);
    			action.execute(req, res);
    			
    		} catch(Exception e){
    			System.out.println(e.getMessage());
    		}
    		
    }
    
}
