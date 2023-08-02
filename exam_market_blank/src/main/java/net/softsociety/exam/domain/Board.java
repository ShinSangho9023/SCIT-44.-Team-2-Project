package net.softsociety.exam.domain;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시글 정보
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board
{
	int boardnum;
	String memberid;
	String title;
	String contents;
	String category;
	String buyerid;
	String inputdate;
	char soldout;
}
