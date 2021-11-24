package com.ssafy.happyhouse.model.dto;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CommentDto {
	
	private int isbn;
	private String comment;
	private Date regtime;
	private String userid;
	private int articleno;

}
