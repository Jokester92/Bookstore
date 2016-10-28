package bookstorejoakim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstorejoakim.domain.Book;
import bookstorejoakim.domain.BookRepository;

@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of students");
			repository.save(new Book("John", "Johnson", 1924, "111-222", 22.99));
			repository.save(new Book("Katy", "Kateson", 1995, "333-444", 23.99));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()){
				log.info(book.toString());
			}
		};
}
}