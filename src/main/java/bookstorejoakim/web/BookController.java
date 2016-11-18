package bookstorejoakim.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstorejoakim.domain.CategoryRepository;
import bookstorejoakim.domain.Book;
import bookstorejoakim.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository; 
	
		 @RequestMapping (value="/login")
		 public String login() {
			 return "login";
		 }
		 	// Show all books
		    @RequestMapping(value="/booklist")
		    public String booklist(Model model) {	
		        model.addAttribute("books", repository.findAll());
		        return "booklist";
		    }
		    
		    // RESTful service to get all books
		    @RequestMapping(value="/books", method = RequestMethod.GET)
		    public @ResponseBody List<Book> bookListRest() {
		    	return (List<Book>) repository.findAll();
		    }
		    
		    // RESTful service to get book by id
		    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
		    public @ResponseBody Book findBookRest (@PathVariable("id") Long bookId) {
		    	return repository.findOne(bookId);
		    }
		    
		    // add new book
		    @RequestMapping(value = "/add")
		    public String addbook(Model model){
		    	model.addAttribute("book", new Book());
		    	model.addAttribute("category", crepository.findAll());
		        return "addbook";
		    }     
		    
		    @RequestMapping(value = "/save", method = RequestMethod.POST)
		    public String save(Book book){
		        repository.save(book);
		        return "redirect:booklist";
		    }    

		    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		    	repository.delete(bookId);
		        return "redirect:./booklist";
		    }     
		}


