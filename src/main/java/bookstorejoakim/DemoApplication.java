package bookstorejoakim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstorejoakim.domain.User;
import bookstorejoakim.domain.UserRepository;
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
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Autobiography"));
			crepository.save(new Category("Fantasy"));
			
			repository.save(new Book("Lover's Paradise", "John Johnson", 1924, "111-222", 22.99, crepository.findByName("Romance").get(0)));
			repository.save(new Book("Dragontales", " Katy Kateson", 1995, "333-444", 23.99, crepository.findByName("Fantasy").get(0)));
			
					User user1 = new User("user", "$2a$08$ZQm8AwGdBWhWcWOEhDPSGuFxHdTaDDi.i7Eb1znF5OGCMvrW6NDgK", "USER");
					User user2 = new User("admin", "$2a$08$TBswbAkWFigUyvZnPORQNOpjouxYTE609Q5sSiV5eiIO63U5U6edC", "ADMIN");
					urepository.save(user1);
					urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()){
				log.info(book.toString());
			}
		};
}
}