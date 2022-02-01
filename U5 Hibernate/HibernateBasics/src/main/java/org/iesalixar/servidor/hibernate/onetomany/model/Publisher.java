package org.iesalixar.servidor.hibernate.onetomany.model;

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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="publishers")
public class Publisher implements Serializable {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name", unique = true, length=100, nullable = false)
	private String name;
	
	
	@Column(name="year", nullable = true)
	@Digits(integer = 4, fraction = 0)
	@Min(value = 1600, message = "")
	@Max(value = 3000, message = "")
	private Integer foundationYear; 
	
	
	@OneToMany(mappedBy="publisher", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Book> books = new HashSet<>();
	
	public Publisher() {
		// TODO Auto-generated constructor stub
	}

	//No tiene sentido el set del ID ya que está auto generado
	public Long getId() {
		return id;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(Integer foundationYear) {
		this.foundationYear = foundationYear;
	}

	public Set<Book> getBooks() {
		return books;
	}
	
	
	//Métodos HELPERs	
	public void addBook(Book book)  {
		this.books.add(book);
		book.setPublisher(this);
	}
	
	public void removeBook(Book book) {
		this.books.remove(book);
		book.setPublisher(null);
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", foundationYear=" + foundationYear + ", books=" + books
				+ "]";
	}
	
	
	
	
}
