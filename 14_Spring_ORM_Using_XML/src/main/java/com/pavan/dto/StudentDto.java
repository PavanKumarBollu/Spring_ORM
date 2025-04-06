package com.pavan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class StudentDto {
	@NonNull
	private Integer sid;
	@NonNull
	private String sname;
	private String saddress;
	private Integer sage;
}
