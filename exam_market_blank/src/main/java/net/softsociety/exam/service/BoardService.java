package net.softsociety.exam.service;

import java.util.ArrayList;
import java.util.HashMap;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {
	//게시글 저장
	int boardInsert(Board board);
	
	//게시글 불러오기
	ArrayList<Board> boardRead();
	
	//게시글 하나 읽기
	Board boardReadOne(int n);
	
	//게시글 삭제
	int deleteBoard(int num);
	
	//상품 구입
	void buyBoard(HashMap<String, String> hashMap);
	
	//댓글 저장
	int replyInput(Reply reply);
	
	//댓글 불러오기
	ArrayList<Reply> getReply(int num);
	
	//글 전체 읽어오기
	ArrayList<Board> searchAll();
	
	//조건 글 읽기
	ArrayList<Board> search(HashMap<String, String> hashMap);
}
