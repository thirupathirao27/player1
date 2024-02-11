package com.music.play.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class AppController {

	@RequestMapping("/msg")
	@ResponseBody
	public String getMsg()
	{
		return "msg is displayed";
	}
	
	@RequestMapping("/player")
	public String Player()
	{
		return "player1.html";
	}
	
	@RequestMapping("/addSong")
	public String addSong()
	{
		return "addSong1.html";
	}
	
	@RequestMapping("/index")
	public String index()
	{
		return "index.html";
	}
	
	@RequestMapping("/view")
	public String view()
	{
		return "view.html";
	}
}
