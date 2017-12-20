package org.dimigo.vo;

public class DashboardVO {
	public DashboardVO() {
		
	}
	
	private int member_id;
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	private String content;
	
}
