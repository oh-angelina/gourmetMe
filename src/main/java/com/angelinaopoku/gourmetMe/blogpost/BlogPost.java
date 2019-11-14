package com.angelinaopoku.gourmetMe.blogpost;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BLOGPOST")
public class BlogPost {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="RESTAURANT")
	private String restaurant; 	
	
	@Column(name="BLOGENTRY")
	private String blogEntry;
	
	public BlogPost() {
		
	}

	public BlogPost(String title, String author, String restaurant, String blogEntry) {
		this.title = title;
		this.author = author;
		this.restaurant = restaurant;
		this.blogEntry = blogEntry;
	}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	
	public String getBlogEntry() {
		return blogEntry;
	}

	public void setBlogEntry(String blogEntry) {
		this.blogEntry = blogEntry;
	}

	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", author=" + author + ", restaurant=" + restaurant + ", blogEntry=" + blogEntry + "]";
	}



	
	
	
}




