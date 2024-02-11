package com.music.play.controller;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.music.play.Dao.SongsDao;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@MultipartConfig
@Controller
public class MusicController {
	
	@Autowired
	private SongsDao dao;

//	@RequestMapping(path="/addSongC1", method=RequestMethod.POST)
//	public ModelAndView addSongController(@RequestParam("sName") String sname,@RequestParam("songFiles") MultipartFile file)
//	{
//		ModelAndView mv=new ModelAndView();
//		System.out.println("thirupathi rao");
//		try {
//		    
//		
//			InputStream in=file.getInputStream();
//			boolean status=dao.insertSong(sname, in);
//			if(status)
//			{
//				mv.addObject("status","YOUR SONG IS ADDED");
//				mv.setViewName("addSong.html");
//				return mv;
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		mv.addObject("status","YOUR SONG IS NOT ADDED");
//		mv.setViewName("addSong.html");
//		return mv;
//	}
	
	@PostMapping("/addSongC")
	public ModelAndView addSongC(@RequestParam("sName") String name,@RequestParam("songFiles") MultipartFile file)
	{
		ModelAndView mv=new ModelAndView();
		try {
			byte[] b=file.getBytes();
			boolean status=dao.insertSong1(name,b);
			if(status)
			{
				mv.addObject("status","YOUR SONG IS ADDED");
				mv.setViewName("addSong1.html");
				return mv;
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("status","THESE SONG IS ALREADY EXIST");
		mv.setViewName("addSong1.html");
		return mv;
	}
	
	@RequestMapping(path="/asa",method=RequestMethod.POST)
	public ModelAndView addSongsInArray()
	{
		ArrayList al=dao.insertSongsIntoArray();
		ModelAndView mv=new ModelAndView();
		mv.addObject("al",al);
		mv.setViewName("player1.html");
		return mv;
		
		
		
	}
	
	@RequestMapping("/viewSongs")
	public ModelAndView viewSongs()
	{
		ArrayList al=dao.ForViewSongs();
		ModelAndView mv=new ModelAndView();
		mv.addObject("al",al);
		mv.setViewName("view1.html");
		return mv;
	}
	
	@RequestMapping("/playFromView")
	public ModelAndView playSongFromViewPage(@RequestParam("song") String name)
	{
		ArrayList al=dao.insertSongsIntoArray();
		ModelAndView mv=new ModelAndView();
		String songName="/songs/"+name;
		mv.addObject("getSong", songName);
		mv.addObject("al", al);
		mv.addObject("animateValue",2);
		mv.addObject("index",2);
		mv.setViewName("player1.html");
		return mv;
	}
	
	@RequestMapping("/deleteSong")
	public ModelAndView deleteSong(@RequestParam("song") String sName)
	{
		ModelAndView mv=new ModelAndView();
		String s="";
		for(int i=0;i<=sName.length()-1;i++)
		{
			char ch=sName.charAt(i);
			if(ch=='.')
			{
				break;
			}
			else {
				s=s+ch;
			}
		}
		boolean status=dao.deleteSong(s);
		if(status)
		{
			mv.setViewName("redirect:/viewSongs");
			return mv;
		}
		return null;
		
	}
	 
	
	
}
