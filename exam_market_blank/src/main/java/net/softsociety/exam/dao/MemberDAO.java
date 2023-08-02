package net.softsociety.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Member;

/**
 * 회원정보 관련 매퍼
 */
@Mapper
public interface MemberDAO {
	// 회원가입 정보 
	int join(Member member);
	// id 중복 체크
	int idCheck(String id);

}
