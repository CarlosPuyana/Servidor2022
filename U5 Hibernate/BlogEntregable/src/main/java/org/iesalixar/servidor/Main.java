package org.iesalixar.servidor;

import java.util.Calendar;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.CommentsDAOImpl;
import org.iesalixar.servidor.dao.UserDAOImpl;
import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.services.ServiceComments;
import org.iesalixar.servidor.services.ServiceCommentsImpl;
import org.iesalixar.servidor.services.ServicePost;
import org.iesalixar.servidor.services.ServicePostImpl;
import org.iesalixar.servidor.services.ServiceUser;
import org.iesalixar.servidor.services.ServiceUserImpl;
import org.iesalixar.servidor.utils.HibernateUtils;

public class Main {
	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();

		Session session = HibernateUtils.getSessionFactory().openSession();

		ServiceComments serviceComments = new ServiceCommentsImpl(session);
		ServicePost servicePost = new ServicePostImpl(session);
		ServiceUser serviceUser = new ServiceUserImpl(session);

		User u1 = new User();
		u1.setUsername("puyana");
		u1.setPassword("123");
		u1.setFirstName("Carlos");
		u1.setLastName("Puyana");
		u1.setEmail("carlos@aaa.com");

		User u2 = new User();
		u2.setUsername("cladus");
		u2.setPassword("123");
		u2.setFirstName("Claudia");
		u2.setLastName("Borracha");
		u2.setEmail("cladus@aaa.com");

		serviceUser.insertNewUser(u1);
		serviceUser.insertNewUser(u2);

		Post p1 = new Post();
		p1.setTitle("Bienvenida");
		p1.setContent("bienvenido a todos");
		calendar.set(Calendar.YEAR, 2019);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		p1.setDate(calendar.getTime());

		Post p2 = new Post();
		p2.setTitle("Despedida");
		p2.setContent("Fuera a todos");
		calendar.set(Calendar.YEAR, 2022);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		p2.setDate(calendar.getTime());

		Post p3 = new Post();
		p3.setTitle("FELIZ ANO");
		p3.setContent("Felicidades a todos");
		calendar.set(Calendar.YEAR, 2021);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		p3.setDate(calendar.getTime());

		Post p4 = new Post();
		p4.setTitle("Bienvenida");
		p4.setContent("bienvenido a todos");
		calendar.set(Calendar.YEAR, 2019);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		p4.setDate(calendar.getTime());

		Post p5 = new Post();
		p5.setTitle("QUE BUEN AÑO");
		p5.setContent("Os espero a todos");
		calendar.set(Calendar.YEAR, 2022);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		p5.setDate(calendar.getTime());

		servicePost.insertNewPost(p1);
		servicePost.insertNewPost(p2);
		servicePost.insertNewPost(p3);
		servicePost.insertNewPost(p4);
		servicePost.insertNewPost(p5);
		
		// Añadimos valoraciones User - Post
		u1.addValoracion(p1, 5);
		u1.addValoracion(p2, 2);
		u1.addValoracion(p3, 7);
		u1.addValoracion(p4, 6);
		u1.addValoracion(p5, 5);
		u2.addValoracion(p1, 3);
		u2.addValoracion(p2, 1);
		u2.addValoracion(p3, 3);
		u2.addValoracion(p4, 9);
		u2.addValoracion(p5, 6);
		
		u1.addPost(p1);
		u1.addPost(p2);
		u1.addPost(p3);
		u2.addPost(p4);
		u2.addPost(p5);
		
		serviceUser.updateUser(u1);
		serviceUser.updateUser(u2);
		
		Comments cm1 = new Comments();
		cm1.setTitle("Esto es una estafa");
		cm1.setContent("Lamentable el servicio postventa");
		
		Comments cm2 = new Comments();
		cm2.setTitle("Maravilla");
		cm2.setContent("Me llego todo de maravilla");
		
		Comments cm3 = new Comments();
		cm3.setTitle("Perfecto");
		cm3.setContent("Como en la foto");
		
		Comments cm4 = new Comments();
		cm4.setTitle("JAJA");
		cm4.setContent("TE QUEMARE EL LOCAL");
		
		serviceComments.insertNewComment(cm1);
		serviceComments.insertNewComment(cm2);
		serviceComments.insertNewComment(cm3);
		serviceComments.insertNewComment(cm4);
		
		// Asociamos Users - Comments
		u1.addComentario(cm1);
		u2.addComentario(cm2);
		u2.addComentario(cm3);
		u1.addComentario(cm4);
		
		serviceUser.updateUser(u1);
		serviceUser.updateUser(u2);
		
		// Asociamos Post - Comentarios
		p1.addComentario(cm1);
		p2.addComentario(cm2);
		p3.addComentario(cm3);
		p4.addComentario(cm4);
		
		// Usamos las funcion de borrar comentario
		u1.removeComentario(cm4);
		
		// Modificamos un Usuario
		u1.setLastName("Paraiso");
		serviceUser.updateUser(u1);
		
		
		// Buscamos un comentario con una palabra determinada
		CommentsDAOImpl daoComments = new CommentsDAOImpl(session);
		
		daoComments.searchByPalabra("servicio");
		
		// Busqueda de todos los usuarios con un usuario o email determinado
		UserDAOImpl daoUser = new UserDAOImpl(session);
		
		daoUser.searchByEmail("puyana", "cladus@aaa.com");
		
		// Busqueda de todos los post de un usuario
		u1.getId();
		
		session.close();

	}
}
