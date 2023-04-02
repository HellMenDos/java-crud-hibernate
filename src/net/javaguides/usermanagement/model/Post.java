package net.javaguides.usermanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	protected String title;
	protected String content;
	//@ManyToOne (optional=false, cascade=CascadeType.ALL)
	protected int user_id;
	
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	public Post(String title, String content, int user_id) {
		this.title = title;
		this.content = content;
		this.user_id = user_id;
	}
	

	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public int getUserId() {
		return user_id;
	}
}
