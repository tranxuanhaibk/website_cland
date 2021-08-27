package edu.vinaenter.cland.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LandDTO {
	
	private int lid;
	private String lname;
	private String description;
	private Timestamp dateCreate;
	private int cid;
	
	private String picture;
	private int area;
	private String address;
	private int countViews;
	private float longitude;
	private float latitude;
	
}
