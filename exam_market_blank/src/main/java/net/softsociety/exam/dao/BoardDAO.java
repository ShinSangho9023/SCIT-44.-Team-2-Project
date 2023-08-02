package net.softsociety.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

/**
 * 게시판 관련 매퍼
 */
@Mapper
public interface BoardDAO {

	// 게시글 저장
	int boardInsert(Board board);
	// 게시글 불러오기
	ArrayList<Board> boardRead();
	// 게시글 하나 읽기
	Board boardReadOne(int n);
	// 게시글 삭제
	int deleteBoard(int num);
	// 게시글 구매
	void buyBoard(HashMap<String, String> hashMap);
	// 댓글 저장
	int replyInput(Reply reply);
	// 댓글 불러오기
	ArrayList<Reply> getReply(int num);
	// 게시글 전체 검색
	ArrayList<Board> searchAll();
	// 게시글 조건 검색
	ArrayList<Board> search(HashMap<String, String> hashMap);

	
}
