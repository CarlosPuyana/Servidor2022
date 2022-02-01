package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="title", nullable = false, length = 50, unique = true)
	private String title;
	
	@Column(name="content", nullable = false, length = 50, unique = false)
	private String content;
	
	@Column(name="date", nullable = false, length = 50, unique = false)
	private Date date;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Valorar> valoraciones = new HashSet<>();
	
	@OneToMany(mappedBy = "postC", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comments> comentarios = new HashSet<>();
	
	@ManyToOne
	private User userP;
	
	
	
	public Post() {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public Set<Comments> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comments> comentarios) {
		this.comentarios = comentarios;
	}

	public Set<Valorar> getValoracion() {
		return valoraciones;
	}

	public void setValoracion(Set<Valorar> valoracion) {
		this.valoraciones = valoracion;
	}

	public User getUserP() {
		return userP;
	}

	public void setUserP(User userP) {
		this.userP = userP;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	public void addComentario(Comments comment) {
		this.comentarios.add(comment);
		comment.setPostC(this);
	}

	public void removeComentario(Comments comment) {
		this.comentarios.remove(comment);
		comment.setPostC(null);
	}
	
	
	
}
