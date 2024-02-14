package com.springbootproject.BookMyShow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity
@Getter
@Setter
public class Theatre
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
    private String theatreLocation;
    private String theatreName;
    @OneToOne(cascade = CascadeType.ALL)
    private TheatreAdmin theatreAdmin;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Screen> screens;
	
    public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreLocation() {
		return theatreLocation;
	}
	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public TheatreAdmin getTheatreAdmin() {
		return theatreAdmin;
	}
	public void setTheatreAdmin(TheatreAdmin theatreAdmin) {
		this.theatreAdmin = theatreAdmin;
	}
	public List<Screen> getScreens() {
		return screens;
	}
	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}
    
    
}
