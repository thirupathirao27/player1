package com.music.play.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.play.entity.MusicData;

public interface SongRepo extends JpaRepository<MusicData, String>{

}
