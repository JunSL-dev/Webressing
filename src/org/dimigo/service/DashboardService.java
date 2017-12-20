package org.dimigo.service;

import java.sql.Connection;

import org.dimigo.dao.DashboardDao;
import org.dimigo.vo.DashboardVO;

public class DashboardService extends AbstractService{
	
	public void mkUI(DashboardVO dashboard) throws Exception{
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			DashboardDao dao = new DashboardDao(conn);
			dao.mkUI(dashboard);
			
		}finally {
			if(conn != null) conn.close();
		}
	}

}
