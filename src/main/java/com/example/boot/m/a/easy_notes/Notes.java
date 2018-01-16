package com.example.boot.m.a.easy_notes;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="note_table")
public class Notes {
	public Notes(Long id, String title, String content, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.created_at = createdAt;
		this.updated_at = updatedAt;
	}
	
	public Notes()
	{
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
//	@Not
	private String title;
	
	private String content;
	//@Column(nullable=false,updatable=false)
//	@Temporal(TemporalType.TIMESTAMP)
	private String created_at;
	//@Column(nullable=false,updatable=false)
//	@Temporal(TemporalType.TIMESTAMP)
	private String updated_at;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
	

}
