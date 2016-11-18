package bookstorejoakim;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import bookstorejoakim.domain.Category;
import bookstorejoakim.domain.BookRepository;
import bookstorejoakim.domain.Book;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {

	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Dragontales");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getIsbn()).isEqualTo("333-444");
	}
	
	
	@Test
	public void createNewBook() {
		Book book = new Book("Musashi", "Eiji Yoshikawa", 1920, "555-999", 29.99, new Category("Biography"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}