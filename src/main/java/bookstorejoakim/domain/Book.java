package bookstorejoakim.domain;

import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

@Id
@GeneratedValue (strategy=GenerationType.AUTO)
		private long id;
		private String Title;
		private String author;
		private Integer year;
		private String isbn;
		private Double price;
		
		public Book(){};
		
		public Book(String title, String author, Integer year,
				String isbn, Double price) {
			super();
			this.id = id;
			Title = title;
			this.author = author;
			this.year = year;
			this.isbn = isbn;
			this.price = price;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public Integer getYear() {
			return year;
		}

		public void setYear(Integer year) {
			this.year = year;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Book [id=" + id + ", Title=" + Title + ", author=" + author
					+ ", year=" + year + ", isbn=" + isbn + ", price=" + price
					+ "]";
		}
		
		
		
}
