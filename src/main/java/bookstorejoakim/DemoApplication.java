package bookstorejoakim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstorejoakim.domain.Category;
import bookstorejoakim.domain.CategoryRepository;
import bookstorejoakim.domain.Book;
import bookstorejoakim.domain.BookRepository;

@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Autobiography"));
			crepository.save(new Category("Fantasy"));
			
			repository.save(new Book("Lover's Paradise", "John Johnson", 1924, "111-222", 22.99, crepository.findByName("Romance").get(0)));
			repository.save(new Book("Dragontales", " Katy Kateson", 1995, "333-444", 23.99, crepository.findByName("Fantasy").get(0)));
			
			
			
			log.info("fetch all books");
			for (Book book : repository.findAll()){
				log.info(book.toString());
			}
		};
}
}