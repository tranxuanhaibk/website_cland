package edu.vinaenter.cland.models;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int id;
	
	@Length(min=5, max=30, message="(Nhập tối thiểu 5 ký tự và tối đa 30 ký tự)")
	private String userName;
	
	@Length(min=5, max=30, message="(Nhập tối thiểu 5 ký tự và tối đa 30 ký tự)")
	private String fullName;
	
	private String authorization;
	
	@Length(min=6, max=20, message="(Nhập mật khẩu tối thiếu 6 ký tứ và tối đa 20 ký tự)")
	private String passWord;

}
