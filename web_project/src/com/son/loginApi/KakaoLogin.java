package com.son.loginApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.son.dao.MemberDao;
import com.son.dto.MemberDto;

/**
 * Servlet implementation class KakaoLogin
 */
@WebServlet("/KakaoLogin")
public class KakaoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String client_id="da2939f67a392415c27c151203c6e60f";
		String redirect_uri="http://diffkdl529.cafe24.com/t001/KakaoLogin";
		String url = "https://kauth.kakao.com/oauth/token?";
		String code=request.getParameter("code");
		url+="grant_type=authorization_code&";
		url+="client_id="+client_id+"&";
		url+="redirect_uri="+redirect_uri+"&";
		url+="code="+code;
		
		URL kakao_url = new URL(url);
		HttpURLConnection conn = (HttpURLConnection)kakao_url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
		///////////////////////////////////////
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		String line=null;
		if(conn.getResponseCode()==200) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		}else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		while((line = br.readLine())!=null) { sb.append(line); }
		JsonParser jParser = new JsonParser();
		System.out.println(sb.toString());
		JsonObject jobj = (JsonObject)jParser.parse(sb.toString());
		System.out.println(jobj.get("access_token").getAsString());
		String access_token = jobj.get("access_token").getAsString();
		br.close();conn.disconnect();
		url="https://kapi.kakao.com/v2/user/me?";
		URL kakao_profile = new URL(url);
		conn = (HttpURLConnection)kakao_profile.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer "+access_token);
		conn.setRequestProperty("Content-type", "application/json;charset=utf-8");
		br = null;
		sb=null;
		sb = new StringBuffer();
		line=null;
		if(conn.getResponseCode()==200) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		while((line=br.readLine())!=null) { sb.append(line); }
		br.close();conn.disconnect();
		String kakao= sb.toString();
		jParser = new JsonParser();
		Gson gson = new Gson();
		MemberDto dto = new MemberDto();
		MemberDao dao = new MemberDao();
		JsonObject jobj1 = (JsonObject)jParser.parse(kakao);
		System.out.println(gson.toJson(jobj1));
		//id값
		String foreignid = jobj1.get("id").getAsString();
		JsonObject jobj2 = (JsonObject)jobj1.get("properties");
		String nickname = jobj2.get("nickname").getAsString();
		String profile_image = jobj2.get("profile_image").getAsString();
		HttpSession session = request.getSession();
		String mname=dao.foreignidChk(foreignid);
		if(mname==null) {
			dto.setForeignid(jobj1.get("id").getAsString());
			dto.setMname(nickname);
			System.out.println(profile_image);
			dto.setMimage(profile_image);
			dto.setMemail(nickname+"@kakao");
			int result =  dao.foreignJoin(dto);
			if(result >0) {
				System.out.println("회원가입");
				session.setAttribute("mname", nickname);
				request.getRequestDispatcher("/mypage_view.members").forward(request, response);
			}
		}else {
			System.out.println("그냥로그인");
			session.setAttribute("mname", mname);
			request.getRequestDispatcher("/mypage_view.members").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
