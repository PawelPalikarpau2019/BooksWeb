package my.projects.controller;

import my.projects.component.BooksManager;
import my.projects.models.BookModel;
import my.projects.models.AuthorRatingModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BooksController.class, secure = false)
public class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BooksManager bookService;

    @Test
    public void test_GetBookByID_Found() throws Exception {
        BookModel responseObject = new BookModel();
        responseObject.setTitle("Test Title");
        responseObject.setPageCount(100500);

        Mockito.when(bookService.getBookByID(anyString())).thenReturn(responseObject);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/7tkN1CYzn2cC").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(result.getResponse().getStatus(), 200);
        assertNull(result.getResponse().getErrorMessage());
        assertEquals(result.getResponse().getContentAsString(), "{\r\n  \"title\" : \"Test Title\",\r\n  \"pageCount\" : 100500\r\n}");
    }

    @Test
    public void test_GetBookByID_NotFound() throws Exception {
        Mockito.when(bookService.getBookByID(anyString())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/7tkN1CYzn2cC").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(result.getResponse().getStatus(), 404);
        assertEquals(result.getResponse().getErrorMessage(), "No results found");
        assertEquals(result.getResponse().getContentAsString(), "");
    }

    @Test
    public void test_GetBooksByCategory_Found() throws Exception {
        List<BookModel> responseObject = new LinkedList<>();

        BookModel firstBook = new BookModel();
        firstBook.setTitle("First Test Title");
        firstBook.setPageCount(100500);

        BookModel secondBook = new BookModel();
        secondBook.setTitle("Second Test Title");
        secondBook.setPageCount(500100);

        responseObject.add(firstBook);
        responseObject.add(secondBook);
        Mockito.when(bookService.getBooksByCategory(anyString())).thenReturn(responseObject);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/category/AnyCategory/books").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();


        assertEquals(result.getResponse().getStatus(), 200);
        assertNull(result.getResponse().getErrorMessage());
        assertEquals(result.getResponse().getContentAsString(), "[ {\r\n  \"title\" : \"First Test Title\",\r\n  \"pageCount\" : 100500\r\n}, {\r\n  \"title\" : \"Second Test Title\",\r\n  \"pageCount\" : 500100\r\n} ]");
    }

    @Test
    public void test_GetBooksByCategory_NotFound() throws Exception {
        Mockito.when(bookService.getBooksByCategory(anyString())).thenReturn(new LinkedList<>());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/category/NotExistingCategory/books").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(result.getResponse().getStatus(), 200);
        assertNull(result.getResponse().getErrorMessage());
        assertEquals(result.getResponse().getContentAsString(), "[ ]");
    }

    @Test
    public void test_GetAuthorsByRatingDesc_Found() throws Exception {
        List<AuthorRatingModel> responseObject = new LinkedList<>();
        AuthorRatingModel firstAuthor = new AuthorRatingModel("First Author", 5.0);
        AuthorRatingModel secondAuthor = new AuthorRatingModel("Second Author", 4.5);
        AuthorRatingModel thirdAuthor = new AuthorRatingModel("Third Author", 3.3);
        responseObject.add(firstAuthor);
        responseObject.add(secondAuthor);
        responseObject.add(thirdAuthor);
        Mockito.when(bookService.getAuthorsByRatingDesc()).thenReturn(responseObject);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/rating").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(result.getResponse().getStatus(), 200);
        assertNull(result.getResponse().getErrorMessage());
        assertEquals(result.getResponse().getContentAsString(), "[ {\r\n  \"author\" : \"First Author\",\r\n  \"averageRating\" : 5.0\r\n}, {\r\n  \"author\" : \"Second Author\",\r\n  \"averageRating\" : 4.5\r\n}, {\r\n  \"author\" : \"Third Author\",\r\n  \"averageRating\" : 3.3\r\n} ]");
    }

    @Test
    public void test_GetAuthorsByRatingDesc_NotFound() throws Exception {
        Mockito.when(bookService.getAuthorsByRatingDesc()).thenReturn(new LinkedList<>());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/rating").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(result.getResponse().getStatus(), 200);
        assertNull(result.getResponse().getErrorMessage());
        assertEquals(result.getResponse().getContentAsString(), "[ ]");
    }
}


//[ {r\n  "author" : "First Author",r\n  "averageRating" : 5.0}, {r\n  "author" : "Second Author",r\n  "averageRating" : 4.5}, {r\n  "author" : "Third Author",r\n  "averageRating" : 3.4\r\n  } ]