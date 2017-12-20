package org.dimigo.action;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.dimigo.service.MemberService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.MemberVO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.MyRenamePolicy;

@MultipartConfig
public class SignUpAction implements IAction{

	public void validate(String name,String userId, String password, String nickname, String email,int phone,boolean isSeller,String account) throws Exception {
		if(CommonUtil.isEmpty(name) ) throw new Exception("이름을 입력하세요");
		if(CommonUtil.isEmpty(userId) ) throw new Exception("아이디를 입력하세요");
		if(CommonUtil.isEmpty(password) ) throw new Exception("비밀번호를 입력하세요");
		if(CommonUtil.isEmpty(nickname) ) throw new Exception("별칭을 입력하세요");
		if(CommonUtil.isEmpty(email) ) throw new Exception("이메일을 입력하세요");
		if(CommonUtil.isEmpty(String.valueOf(phone)) ) throw new Exception("전화번호를 입력하세요");
		if(isSeller) {
			if(CommonUtil.isEmpty(String.valueOf(account)) ) throw new Exception("계좌번호를 입력하세요");			
		}		
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("application/json;charset=utf-8");
		String path2 = req.getServletPath();
		System.out.println(path2);
		String path = "s";
		String timemask = ""+System.currentTimeMillis(); 
		System.out.println("timemask="+timemask);
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		PrintWriter out = res.getWriter();
	
		
		try {
			// 파일 업로드용!
			MultipartRequest multi = new MultipartRequest(req,path,10*1024*1024,"utf-8",new MyRenamePolicy());
			System.out.println(path);
			System.out.println(multi.getFilesystemName("fileName"));
			System.out.println(multi.getFile("fileName"));
			System.out.println(multi.getOriginalFileName("fileName"));
			
			// 회원가입으로 받은 정보
			String name = multi.getParameter("name");
			String userId = multi.getParameter("userId");
			String password = multi.getParameter("password");
			String passwordCheck = multi.getParameter("passwordCheck");
			String nickname = multi.getParameter("nickname");
			String email = multi.getParameter("email");
			String gender;
			String male = multi.getParameter("maleR");
			String female = multi.getParameter("femaleR");
			String profile_content = multi.getParameter("profile-content");
			boolean isSeller;
			System.out.println("판매자 여부 : " + multi.getParameter("isSeller"));
			
			if(multi.getParameter("isSeller")==null) {
				System.out.println("뜬금 확인");
				isSeller = false;
			} else if(multi.getParameter("isSeller").equals("true")){
				isSeller = true;
			} else {
				isSeller = false;
			}
			
			if(male == null) {
				gender = "female";
			} else {
				gender = "male";
			}
			
			String phone_tmp = multi.getParameter("phone");
			int phone = Integer.parseInt(phone_tmp);
						
			String account = multi.getParameter("account");
			
			System.out.println("이름 : "+name);
			System.out.println("아이디 : "+userId);
			System.out.println("비밀번호 : "+password);
			System.out.println("비밀번호 확인 : "+passwordCheck);
			System.out.println("닉네임 : "+nickname);
			System.out.println("성별 : "+gender);
			System.out.println("성별m : "+male);
			System.out.println("성별f : "+female);
			System.out.println("전화번호 : "+phone);
			System.out.println("이메일 : "+email);
			System.out.println("계좌번호 : "+account);
			System.out.println("판매자 여부 : "+isSeller);
			
			validate(name,userId,password,nickname,email,phone,isSeller,account);
			
			MemberVO member = new MemberVO();
			
			MemberService service = new MemberService();
			
			member.setName(name);
			member.setUserId(userId);
			member.setPhone(phone);
			member.setEmail(email);
			member.setNickname(nickname);
			member.setAccount(account);	
			member.setSeller(isSeller);
			member.setGender(gender);
			member.setProfileImage(multi.getFilesystemName("fileName"));
			member.setProfile_content(profile_content);
						
			if(!password.equals(passwordCheck)) {
				System.out.println("비밀번호가 달라연");
				obj.addProperty("duplicate", true);
				out.write(gson.toJson(obj));
				out.close();
				
			} else {
				System.out.println("비밀번호가 같아연");

				member.setPassword(password);				
				service.signUp(member);
				
				obj.addProperty("login", true);
				out.write(gson.toJson(obj));
				out.close();
			}
		} catch(NumberFormatException e) {
			e.printStackTrace();			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
			RequestDispatcher rd = req.getRequestDispatcher("jsp/signup.jsp");
			rd.forward(req, res);
		}
	}

}
