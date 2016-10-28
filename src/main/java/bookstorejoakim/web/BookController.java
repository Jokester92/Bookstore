package bookstorejoakim.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstorejoakim.domain.Book;
import bookstorejoakim.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository; 
	
		 @RequestMapping (value="/hello")
		 public String helloWorld() {
			 return "index";
		 }
		 
		    @RequestMapping(value="/booklist")
		    public String booklist(Model model) {	
		        model.addAttribute("books", repository.findAll());
		        return "booklist";
		    }
		  
		    @RequestMapping(value = "/add")
		    public String addbook(Model model){
		    	model.addAttribute("book", new Book());
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

