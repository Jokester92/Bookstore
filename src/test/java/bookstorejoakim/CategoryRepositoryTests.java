package bookstorejoakim;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import bookstorejoakim.domain.Category;
import bookstorejoakim.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Category> categories = repository.findByName("Fantasy");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCategoryid()).isEqualTo("3");
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Sci-fi");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}

}