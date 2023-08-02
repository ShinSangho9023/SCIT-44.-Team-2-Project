package net.softsociety.exam.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Member;
import net.softsociety.exam.service.MemberService;

/**
 * 회원 정보 관련 콘트롤러
 */

@Slf4j
@RequestMapping("member")
@Controller
public class MemberController 
{
	@Autowired
	MemberService service;
	
	
	//회원가입 홈페이지 접속
	@GetMapping("join")
	public String join() 
	{
		log.debug("회원가입 홈페이지 접근");
		return "signupForm";
	}
	
	
	//회원가입
	@PostMapping("join")
	public String joinForm(Member member) 
	{
		log.debug("회원 가입 보냄");
		int n = service.join(member);
		log.debug("회원 가입 돌아옴");
		return "redirect:/";
	}
	
	//로그인 홈페이지 접속
	@GetMapping("login")
	public String login()
	{
		log.debug("로그인 홈페이지 접근");
		return "loginForm";
	}
	
	//아이디 중복 체크
	@ResponseBody
	@GetMapping("idCheck")
	public String idCheck(String id) 
	{
		log.debug("아이디 중복 체크 접속");
		
		int n = service.idCheck(id);
		
		log.debug("n 값 확인 : ",n);
		String idCount = Integer.toString(n);
		
		return idCount;
	}
	
	
}
