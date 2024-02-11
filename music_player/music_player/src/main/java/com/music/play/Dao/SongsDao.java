package com.music.play.Dao;

import java.io.File;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.music.play.entity.MusicData;
import com.music.play.repository.SongRepo;

@Component
public class SongsDao {

	@Autowired
	private SongRepo repo;
	
	@Autowired
	private MusicData entity;
	
	
	
	public boolean insertSong1(String name,byte[] b)
	{
		entity.setName(name);
		entity.setBlobFiles(b);
		try {
		repo.save(entity);
		fetchAllSongsToStaticFolder(name);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void deleteFiles(String name)
	
	{
		String sName=name+".mp3";
		File file=new File("C:\\Users\\hp\\Downloads\\music_player\\music_player\\src\\main\\resources\\static\\songs");
		File[] fileList=file.listFiles();
	
		for(File f:fileList)
		{
			if(f.getName().equalsIgnoreCase(sName))
			{
				f.delete();
			}
		}
		
		
    }
	
	
	public void fetchAllSongsToStaticFolder(String name)
	{
	       Optional op=repo.findById(name);
	       MusicData data=(MusicData)op.get();
		try {
			
			
			FileOutputStream fos=new FileOutputStream("C:\\Users\\hp\\Downloads\\music_player\\music_player\\src\\main\\resources\\static\\songs\\"+name+".mp3");
			   fos.write(data.getBlobFiles());
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList insertSongsIntoArray()
	{
		ArrayList al=new ArrayList();
		File file=new File("C:\\Users\\hp\\Downloads\\music_player\\music_player\\src\\main\\resources\\static\\songs\\");
		File[] fileList=file.listFiles();
		for(File f:fileList)
		{
			al.add("/songs/"+f.getName());
		}
		return al;
	}
	
	 
	public ArrayList ForViewSongs()
	{
		ArrayList al=new ArrayList();
		File file=new File("C:\\Users\\hp\\Downloads\\music_player\\music_player\\src\\main\\resources\\static\\songs\\");
		File[] fileList=file.listFiles();
		for(File f:fileList)
		{
			al.add(f.getName());
		}
		return al;
	}
	
	public boolean deleteSong(String name)
	{
		try {
		repo.deleteById(name);
		deleteFiles(name);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
}
