package com.springbootproject.BookMyShow.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity
@Getter
@Setter
public class TheatreAdmin 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreAdminId;
	private String theatreAdminName;
	private String theatreAdminPass;
	@OneToOne(cascade = CascadeType.ALL)
	private Theatre theatre;
	
	public int getTheatreAdminId() {
		return theatreAdminId;
	}
	public void setTheatreAdminId(int theatreAdminId) {
		this.theatreAdminId = theatreAdminId;
	}
	public String getTheatreAdminName() {
		return theatreAdminName;
	}
	public void setTheatreAdminName(String theatreAdminName) {
		this.theatreAdminName = theatreAdminName;
	}
	public String getTheatreAdminPass() {
		return theatreAdminPass;
	}
	public void setTheatreAdminPass(String theatreAdminPass) {
		this.theatreAdminPass = theatreAdminPass;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	
	
	
}
