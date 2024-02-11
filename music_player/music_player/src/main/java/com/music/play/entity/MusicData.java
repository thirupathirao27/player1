package com.music.play.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class MusicData {

	@Id
	public String name;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	public byte[] blobFiles;
	
	
	
}
