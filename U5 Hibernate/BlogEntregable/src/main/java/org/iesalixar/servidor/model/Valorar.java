package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@IdClass(UserPostId.class)
public class Valorar implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="user", insertable = false, updatable = false)
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(name="post", insertable = false, updatable = false)
	private Post post;
	
	private Integer puntuacion;

	public Valorar() {
		// TODO Auto-generated constructor stub
	}

	public Valorar(User user, Post post) {
		super();
		this.user = user;
		this.post = post;
	}

	public Valorar(User user, Post post, Integer puntuacion) {
		super();
		this.user = user;
		this.post = post;
		this.puntuacion = puntuacion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(post, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valorar other = (Valorar) obj;
		return Objects.equals(post, other.post) && Objects.equals(user, other.user);
	}
	
	
	
	

}
