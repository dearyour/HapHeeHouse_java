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
public class ReplyDto {
	
	private int replyUserid;
	private String replyContent;
	private Date replyDatetime;
	private String user_id;
	private BoardDto boardNo;

}
