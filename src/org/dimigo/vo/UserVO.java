package org.dimigo.vo;

public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private String nickname;
	
	public UserVO() {
		
	}
	
	public UserVO(String id, String name, String nickname) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
