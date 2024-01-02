package com.momo.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;

public class CookieManager {

	public CookieManager() {
		
	}
	
	/**
	 * 쿠키를 생성후 응답 객체에 저장
	 * 
	 * 쿠키를 생성하기 위해 필요한 값
	 * - 쿠키 이름, 쿠키값, 시간
	 * 
	 * 사용자에게 응답하기 위해서 
	 * - 응답객체를 매개변수로 전달 받는다.
	 */
	//static : 서버가 실행하면서 만들어줘서 생성하지 않아도 됨.
	//응답 객체에서 받아오기 위해서
	public static void makeCookie(
			HttpServletResponse response
			, String name
			, String value
			, int time) {
		
		// 쿠키생성
		Cookie cookie = new Cookie(name, value);
		
		// 유지기간 설정
		cookie.setMaxAge(time);
		
		// 응답객체에 추가
		response.addCookie(cookie);
		
	}
	/**
	 * 요청 객체로부터 쿠키 배열을 가지고 온뒤 원하는 쿠키이름을 찾아서 쿠키값을 반환
	 * @return
	 */
	public static String readCookie(
			HttpServletRequest request
			, String name) {
		String value = "";
		
		// 요청객체로 부터 쿠키배열을 획득
		Cookie[] cookies = request.getCookies();
		
		//브라우저를 통해 처음 접근했을때.
		//쿠키가 하나도 저장되어 있지 않은 경우 getcookes메서드를 호출하면 null을 반환
	
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals(name)) {
				value = cookie.getValue();
				break;
			}
		}
		return value;
	}
	/**
	 * 쿠키를 삭제 합니다.
	 * @param response
	 * @param name
	 */
	public static void deleteCookie(
			HttpServletResponse response
			, String name
			) {
		makeCookie(response, name, "", 0);
	}
}

