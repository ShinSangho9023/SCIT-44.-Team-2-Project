package net.softsociety.exam.service;

import net.softsociety.exam.domain.Member;

/** 
 * 회원정보 관련 서비스
 */
public interface MemberService {
	//회원가입
	int join(Member member);
	//ID 중복확인
	int idCheck(String id);

}
