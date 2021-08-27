package edu.vinaenter.cland.models;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Land {
	private int lid;
	@Length(min=5, max=100, message="(Nhập tối thiểu 5 ký tự và tối đa 100 ký tự)")
	private String lname;
	@Length(min=5, max=1000, message="(Nhập tối thiểu 5 ký tự và tối đa 300 ký tự)")
	private String description;
	
	private Timestamp dateCreate;
	
	private Category category;
	
	private String picture;
	@NotNull(message="(Diện tích không được rỗng)")
	private int area;
	@Length(min=5, max=100, message="(Nhập tối thiểu 5 ký tự và tối đa 100 ký tự)")
	private String address;
	
	private int countViews;
	private int status;
	
	private float longitude;
	private float latitude;
}
