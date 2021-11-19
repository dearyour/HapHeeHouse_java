package com.ssafy.happyhouse.model.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
public class QnaDto {
	@NonNull
	private int qnaNo;
	private String qnaName;
	private Date writeDate;
	private String content;
	private int total;
	private String userid;
	private String replyContent;
	private Date replyDatetime;
	private String replyUserid;
}
