package my.projects.controller;

import my.projects.component.BooksManager;
import my.projects.models.BookModel;
import my.projects.models.AuthorRatingModel;
import my.projects.response.BookNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class BooksController {

    @Autowired
    private BooksManager booksService;

    @RequestMapping(value = "/api/book/{ID}", method = RequestMethod.GET, produces = {"application/json"})
    public BookModel getBookByID(@PathVariable String ID) {
        BookModel response = booksService.getBookByID(ID);
        if (response == null) throw new BookNotFoundException();
        return response;
    }

    @RequestMapping(value = "/api/category/{categoryName}/books", method = RequestMethod.GET, produces = {"application/json"})
    public List<BookModel> getBooksByCategory(@PathVariable String categoryName) {
        return booksService.getBooksByCategory(categoryName);
    }

    @RequestMapping(value = "/api/rating", method = RequestMethod.GET, produces = {"application/json"})
    public List<AuthorRatingModel> getAuthorsByRatingDesc() {
        return booksService.getAuthorsByRatingDesc();
    }
}
