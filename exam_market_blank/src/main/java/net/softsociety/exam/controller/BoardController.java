package net.softsociety.exam.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;
import net.softsociety.exam.service.BoardService;

/**
 * 상품게시판 관련 콘트롤러
 */
@Slf4j
@RequestMapping("board")
@Controller
public class BoardController 
{
	
	@Autowired
	BoardService service;
	
	//판매정보 게시판 페이지 접속 & 게시글 불러오기
	@GetMapping("sellInfoBoard")
	public String sellInfoBoard(Model model) 
	{
		log.debug("판매정보 게시판 접속");
		ArrayList<Board> list = new ArrayList<Board>();
		list = service.boardRead();
		model.addAttribute("list",list);
		log.debug("게시판 목록 불러오기 {}",list);
		log.debug("게시판 창 이동");
		return "sellInfoBoard";
	}
	//판매글 등록 페이지 접속
	@GetMapping("sellBoard")
	public String sellBoard() 
	{
		log.debug("판매글 등록 접속");
		return "sellBoardInsert";
	}
	
	//판매상품 검색 페이지 접속
	@GetMapping("sellInfoSearchBoard")
	public String sellInfoSearchBoard() 
	{
		log.debug("판매상품 검색 접속");
		
		return "sellInfoSearchBoard";
	}
	
	//게시글 저장
	@PostMapping("boardInsert")
	public String boardInsert(Board board, @AuthenticationPrincipal UserDetails user) {
		log.debug("카테고리 : {}", board.getCategory());
		log.debug("콘텐츠 : {}", board.getContents());
		board.setMemberid(user.getUsername());
		
		int n = service.boardInsert(board);
		return "redirect:sellInfoBoard";
	}
	
	//게시글 하나 불러오기(상품 페이지 불러오기)
	@GetMapping("boardReadOne")
	public String boardReadOne(Model model, String boardnum, Board board) 
	{
		log.debug("게시물 읽으러 감");
		int n = Integer.parseInt(boardnum);
		board = service.boardReadOne(n);
		log.debug("가져온 보드 정보 :{}", board);
		model.addAttribute("board", board);
		log.debug("가져온 보드 정보 :{}", board);
		return "sellInfo";
	}
	
	// 게시글 삭제
	@GetMapping("delete")
	public String delete(String boardnum) 
	{
		int num = Integer.parseInt(boardnum);
		log.debug("게시물 삭제하러 감");
		int n = service.deleteBoard(num);
		log.debug("게시물 삭제 : {}", n);
		return "sellInfoBoard";
	}
	
	//상품 구입
	@GetMapping("buyBoard")
	public String buyBoard(String boardnum, @AuthenticationPrincipal UserDetails user) 
	{
		HashMap<String, String> hashMap = new HashMap<>();
		log.debug("게시물 사러 들어감");
		int num = Integer.parseInt(boardnum);
		
		hashMap.put("boardnum",boardnum);
		hashMap.put("memberid",user.getUsername());
		service.buyBoard(hashMap);
		log.debug("게시물 사고 옴");

		return "sellInfoBoard";
	}
	
	//게시글 저장
	@ResponseBody
	@GetMapping("replyInput")
	public void replyInput(String memberid, String replytext, String boardnum, Reply reply) 
	{
		log.debug("게시글 번호 : {}", boardnum);
		log.debug("맴버 아이디 : {}", memberid);
		log.debug("게시글 내용 : {}", replytext);
		int num = Integer.parseInt(boardnum);
		reply.setBoardnum(num);
		reply.setMemberid(memberid);
		reply.setReplytext(replytext);
		log.debug("게시글 번호 : {}", reply.getBoardnum());
		log.debug("맴버 아이디 : {}", reply.getMemberid());
		log.debug("게시글 내용 : {}", reply.getReplytext());
		
		int n = service.replyInput(reply);
	}
	
	//댓글 리스트로 받아오기
	@ResponseBody  
	@GetMapping("getReply")
	public ArrayList<Reply> getReply(String boardnum) 
	{		
			ArrayList<Reply> list = new ArrayList<>();
			int num = Integer.parseInt(boardnum);
			list = service.getReply(num);
			
			log.debug("Reply : {}",list);
			return list;
	}
	
	//게시글 전부 조회 (ajax)
	@ResponseBody  
	@GetMapping("searchAll")
	public ArrayList<Board> searchAll() 
	{		
			ArrayList<Board> list = new ArrayList<>();
			list = service.searchAll();
			
			log.debug("Reply : {}",list);
			return list;
	}
	
	//게시글 조건 검색(ajax)
	@ResponseBody  
	@GetMapping("search")
	public ArrayList<Board> search(String category, String keyword) 
	{		
			HashMap<String, String> hashMap = new HashMap<>();
			ArrayList<Board> list = new ArrayList<>();
			hashMap.put("category",category);
			hashMap.put("keyword",keyword);
			
			list = service.search(hashMap);
			
			log.debug("Reply : {}",list);
			return list;
	}
	
	
}
