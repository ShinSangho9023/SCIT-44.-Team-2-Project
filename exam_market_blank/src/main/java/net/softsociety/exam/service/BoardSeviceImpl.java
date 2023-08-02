package net.softsociety.exam.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.dao.BoardDAO;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

@Slf4j
@Transactional
@Service
public class BoardSeviceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	//게시글 저장
	@Override
	public int boardInsert(Board board) 
	{
		
		int n = dao.boardInsert(board);
		return n;
	}

	//게시글 불러오기
	@Override
	public ArrayList<Board> boardRead() 
	{
		ArrayList<Board> list = new ArrayList<Board>();
		list = dao.boardRead();
		
		return list;
	}

	//게시글 하나 읽기
	@Override
	public Board boardReadOne(int n) 
	{
		Board board = new Board();
		board = dao.boardReadOne(n);
		log.debug("게시물 하나 서비스 단: ",board);
		return board;
	}

	//게시글 삭제
	@Override
	public int deleteBoard(int num) {
		
		int n = dao.deleteBoard(num);
		return n;
	}

	//상품 구입
	@Override
	public void buyBoard(HashMap<String, String> hashMap) {
		dao.buyBoard(hashMap);
	}

	//댓글 저장
	@Override
	public int replyInput(Reply reply) 
	{
		int n = dao.replyInput(reply);
		return n;
	}
	
	//댓글 불러오기
	@Override
	public ArrayList<Reply> getReply(int num) 
	{
		ArrayList<Reply> list = new ArrayList<>();
		list = dao.getReply(num);
		
		log.debug("Reply : {}",list);
		return list;
	}

	//글 전체 읽어오기
	@Override
	public ArrayList<Board> searchAll() {
		
		ArrayList<Board> list = new ArrayList<>();
		list = dao.searchAll();
		
		log.debug("Reply : {}",list);
		return list;
	}
	
	//조건 글 읽기
	@Override
	public ArrayList<Board> search(HashMap<String, String> hashMap) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<>();
		list = dao.search(hashMap);
		
		return list;
	}
	
}
