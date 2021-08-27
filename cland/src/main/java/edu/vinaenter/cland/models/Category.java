package edu.vinaenter.cland.models;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	private int cid;
	
	@Length(min=5,max=20, message="Tối thiểu 5 ký tự, Tối đa 15 ký tự !")
	private String cname;


}
