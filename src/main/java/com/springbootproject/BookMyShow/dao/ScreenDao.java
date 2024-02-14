package com.springbootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootproject.BookMyShow.entity.Screen;
import com.springbootproject.BookMyShow.repository.ScreenRepository;

@Repository
public class ScreenDao 
{
	@Autowired
	ScreenRepository screenRepository;
	
	public Screen saveScreen(Screen screen)
	{
		return screenRepository.save(screen);
	}
	
	public Screen findScreen(int screenNum)
	{
		Optional<Screen> optional = screenRepository.findById(screenNum);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public Screen deleteScreen(int screenNum)
	{
		Screen exScreen=findScreen(screenNum);
		if(exScreen!=null)
		{
			screenRepository.deleteById(screenNum);
		    return exScreen;
		}
	
		return null;
	}

	public Screen updateScreen(Screen screen,int screenId)
	{
		Screen exScreen=findScreen(screenId);
		
		if(exScreen!=null)
		{
			screen.setScreenNum(screenId);
			return screenRepository.save(screen);
		}
		return null;
	}
	
	public List<Screen> findAllScreens()
	{
		return screenRepository.findAll();
	}
}
