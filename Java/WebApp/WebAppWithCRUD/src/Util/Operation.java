package Util;

import java.util.Iterator;
import java.util.List;

import org.hibernate.*;


import Entity.Book;

public class Operation {
	Session session = HibernateUtil.getCurrentSession();
	Transaction transaction = null;
	
	
	public void add(String book_author, String book_pub_date, String book_name, int book_pages, String book_state){
		try {
			transaction = session.beginTransaction();
			//transaction.begin();
			Book newbook = new Book();
			newbook.setAuthor(book_author);
			newbook.setName(book_name);
			newbook.setPub_date(book_pub_date);
			newbook.setState(book_state);
			newbook.setPages(book_pages);
			session.save(newbook);
			transaction.commit();
			System.out.println("New book added sucessessfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	
	public void delete(String book_name){
		try {
			transaction = session.beginTransaction();
			String queryString = "from Book where name = :name";
			Query query = session.createQuery(queryString);
			query.setString("name", book_name);
			Book book = (Book)query.uniqueResult();
			if(book == null){
				System.out.println("There is no such a book!");
			}else{
				session.delete(book);
				transaction.commit();
				System.out.println("Book records deleted!");
			}
			

		} catch (HibernateException e) {

			transaction.rollback();

			e.printStackTrace();

		} finally {

			HibernateUtil.closeSession(session);

		}
	}
	
	
	public void edit(String book_author, String book_pub_date, String book_name, int book_pages, String book_state){
		try {
			transaction = session.beginTransaction();
			String queryString = "from Book where name = :name";
			Query query = session.createQuery(queryString);
			query.setString("name", book_name);
			Book book = (Book)query.uniqueResult();
			if(book == null){
				System.out.println("There is no such a book!");
			}else{
				book.setAuthor(book_author);
				book.setPages(book_pages);
				book.setName(book_name);
				book.setPub_date(book_pub_date);
				book.setState(book_state);
				session.update(book);
				transaction.commit();
				System.out.println("Book records updated!");
			}
			
		} catch (HibernateException e) {

			transaction.rollback();

			e.printStackTrace();

		} finally {

			HibernateUtil.closeSession(session);

		}
	}
	
	
	
	
	public void retrieve(String book_name){
		try {
			transaction = session.beginTransaction();
			String queryString = "from Book where name = :name";
			Query query = session.createQuery(queryString);
			query.setString("name", book_name);
			Book book = (Book)query.uniqueResult();
			if(book == null){
				System.out.println("There is no such a book!");
			}else{
				transaction.commit();
				System.out.println("This book is found! " + "And the information of the book is listed below: ");
				System.out.println("The author of the book is " + book.getAuthor());
				System.out.println("The name of the book is " + book.getName());
				System.out.println("The publish date of the book is " + book.getPub_date());
				System.out.println("The state of the book is " + book.getState());
				System.out.println("The pages of the book is " + book.getPages());
			}
			
			


		} catch (HibernateException e) {

			transaction.rollback();

			e.printStackTrace();

		} finally {

			HibernateUtil.closeSession(session);

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
