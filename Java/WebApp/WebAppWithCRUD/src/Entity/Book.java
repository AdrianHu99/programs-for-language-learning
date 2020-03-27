package Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Book {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String state;
	private String author;
	private String pub_date;
	private int pages;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	
}
