package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "username", nullable = false, length = 50, unique = true)
	private String username;

	@Column(name = "password", nullable = false, length = 50, unique = false)
	private String password;

	@Column(name = "firstName", nullable = false, length = 50, unique = false)
	private String firstName;

	@Column(name = "lastName", nullable = false, length = 50, unique = false)
	private String lastName;

	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Valorar> valoraciones = new HashSet<>();

	@OneToMany(mappedBy = "userC", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comments> comentarios = new HashSet<>();

	@OneToMany(mappedBy = "userP", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Post> postU = new HashSet<>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Valorar> getValoracion() {
		return valoraciones;
	}

	public void setValoracion(Set<Valorar> valoracion) {
		this.valoraciones = valoracion;
	}

	public Set<Comments> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comments> comentarios) {
		this.comentarios = comentarios;
	}

	public Set<Post> getPostU() {
		return postU;
	}

	public void setPostU(Set<Post> postU) {
		this.postU = postU;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	// Helpers

	public void addValoracion(Post post, Integer puntuacion) {

		Valorar valoracion = new Valorar(this, post, puntuacion);
		this.valoraciones.add(valoracion);
		post.getValoracion().add(valoracion);

	}

	public void removeValoracion(Post post) {
		Valorar valoracion = new Valorar(this, post);
		this.valoraciones.remove(valoracion);
		post.getValoracion().remove(valoracion);
	}

	public void addComentario(Comments comment) {
		this.comentarios.add(comment);
		comment.setUserC(this);
	}

	public void removeComentario(Comments comment) {
		this.comentarios.remove(comment);
		comment.setUserC(null);
	}

	public void addPost(Post post) {
		this.postU.add(post);
		post.setUserP(this);
	}

	public void removePost(Post post) {
		this.postU.remove(post);
		post.setUserP(null);
	}

}
