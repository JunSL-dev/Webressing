package org.dimigo.vo;

public class MemberVO {
	
	public MemberVO(){
		
	}
	
	private int id;
	private String userId;
	private String name;
	private String password;
	private String nickname;
	private String email;
	private String profileImage;
	private String gender;
	private String earn;
	private String profile_content;
	
	private boolean isSeller;
	
	private int phone;
	private String account;
	
	public int getId() {
		return id;
	}
	
	public void setId(int Id) {
		this.id = Id;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSeller() {
		return isSeller;
	}
	public void setSeller(boolean isSeller) {
		this.isSeller = isSeller;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getProfileImage() {
		return this.profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEarn() {
		return this.earn;
	}
	public void setEarn(String earn) {
		this.earn = earn;
	}
	public void setProfile_content(String profile_content){
		this.profile_content = profile_content;
	}
	public String getProfile_content(){
		return this.profile_content;
	}
	
	
}
