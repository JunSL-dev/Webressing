package org.dimigo.service;

import java.sql.Connection;
import java.util.List;

import org.dimigo.dao.DashboardDao;
import org.dimigo.vo.DashboardVO;
import org.dimigo.vo.MemberVO;

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
	
	public List<DashboardVO> getDashboard(MemberVO member) throws Exception{
		Connection conn = null;
		try {
			conn = getConnection();
			
			DashboardDao dao = new DashboardDao(conn);
			return dao.getDashboard(member);
		} finally {
			if(conn != null) conn.close();
		}
	}

}
