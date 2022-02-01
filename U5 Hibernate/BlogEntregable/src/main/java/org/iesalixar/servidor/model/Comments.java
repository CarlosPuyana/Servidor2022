package org.iesalixar.servidor.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comments {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@Column(name="content", nullable = false)
	private String content;
	
	@ManyToOne
	private User userC;
	
	@ManyToOne
	private Post postC;
	
	public Comments() {
		// TODO Auto-generated constructor stub
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

	public Long getId() {
		return id;
	}

	public User getUserC() {
		return userC;
	}

	public void setUserC(User userC) {
		this.userC = userC;
	}

	public Post getPostC() {
		return postC;
	}

	public void setPostC(Post postC) {
		this.postC = postC;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comments other = (Comments) obj;
		return Objects.equals(title, other.title);
	}
	
	
	
}
