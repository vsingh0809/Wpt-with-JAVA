package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String content; 
	@Column(length = 50)
	private String description;
	@Column(length = 50)
	private String imagePath;
	@Column(length = 50, unique = true)
	private String title;
	
	
	public Post(String content, String description, String imagePath, String title) {
		this.content = content;
		this.description = description;
		this.imagePath = imagePath;
		this.title = title;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", description=" + description + ", imagePath=" + imagePath
				+ ", title=" + title + "]";
	}
	
	
}
