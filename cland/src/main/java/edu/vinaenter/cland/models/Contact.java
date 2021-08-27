package edu.vinaenter.cland.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	
	private int cid;
	@Length(min=5, max=40, message="(Nhập tối thiểu 5 ký tự và tối đa 30 ký tự)")
	private String fullname;
	@NotEmpty
	@Email
	private String email;
	@NotNull(message = "(Vui lòng không để trống)")
	private String subject;
	@NotNull(message = "(Vui lòng không để trống)")
	private String content;
	@NotNull(message = "(Vui lòng không để trống)")
	private String phone;
	

}
