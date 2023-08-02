package net.softsociety.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.exam.dao.MemberDAO;
import net.softsociety.exam.domain.Member;

@Service
public class MemberSeviceImpl implements MemberService {

	@Autowired
	MemberDAO dao;
	
	@Autowired
	private PasswordEncoder PE;
	
	@Override
	public int join(Member member) 
	{
		String pw = PE.encode(member.getMemberpw());
		member.setMemberpw(pw);
		int n = dao.join(member);
		return n;
	}

	@Override
	public int idCheck(String id) 
	{
		int n = dao.idCheck(id);
		return n;
	}

   

}
