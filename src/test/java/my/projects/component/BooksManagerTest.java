package my.projects.component;

import my.projects.models.AuthorRatingModel;
import my.projects.models.BookModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SpringBootTest
public class BooksManagerTest {

    @Before
    public void initMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_GetBookByID_NotFound() {
        BookModel result = new BooksManager().getBookByID("notexisting");
        assertNull(result);
    }

    @Test
    public void test_GetBookByID_FoundByISBN() {
        BookModel result = new BooksManager().getBookByID("9780071606325");

        assertNotNull(result);

        assertEquals(result.getIsbn(), "9780071606325");
        assertEquals(result.getTitle(), "Java, A Beginner's Guide, 5th Edition");
        assertNull(result.getSubtitle());
        assertEquals(result.getPublisher(), "McGraw Hill Professional");
        assertEquals((long) result.getPublishedDate(), 1313445600000L);
        assertEquals(result.getDescription(), "Essential Skills--Made Easy! Learn the fundamentals of Java programming in no time from bestselling programming author Herb Schildt. Fully updated to cover Java Platform, Standard Edition 7 (Java SE 7), Java: A Beginner's Guide, Fifth Edition starts with the basics, such as how to compile and run a Java program, and then discusses the keywords, syntax, and constructs that form the core of the Java language. You'll also find coverage of some of Java's most advanced features, including multithreaded programming and generics. An introduction to Swing concludes the book. Get started programming in Java right away with help from this fast-paced tutorial. Designed for Easy Learning: Key Skills & Concepts--Chapter-opening lists of specific skills covered in the chapter Ask the Expert--Q&A sections filled with bonus information and helpful tips Try This--Hands-on exercises that show you how to apply your skills Self Tests--End-of-chapter questions that test your understanding Annotated Syntax--Example code with commentary that describes the programming techniques being illustrated");
        assertEquals((int) result.getPageCount(), 640);
        assertEquals(result.getThumbnailUrl(), "http://books.google.com/books/content?id=L7HoaI4yyREC&printsec=frontcover&img=1&zoom=1&source=gbs_api");
        assertEquals(result.getLanguage(), "en");
        assertEquals(result.getPreviewLink(), "http://books.google.pl/books?id=L7HoaI4yyREC&q=java&dq=java&hl=&cd=23&source=gbs_api");
        assertNotNull(result.getAuthors());
        assertEquals(result.getAuthors().size(), 1);
        assertEquals(result.getAuthors().get(0), "Herbert Schildt");
        assertNotNull(result.getCategories());
        assertEquals(result.getCategories().size(), 1);
        assertEquals(result.getCategories().get(0), "Computers");
    }

    @Test
    public void test_GetBookByID_FoundByID() {
        BookModel result = new BooksManager().getBookByID("UEdjAgAAQBAJ");

        assertNotNull(result);

        assertEquals(result.getIsbn(), "9788324677610");
        assertEquals(result.getTitle(), "Java. Podstawy. Wydanie IX");
        assertNull(result.getSubtitle());
        assertEquals(result.getPublisher(), "Helion");
        assertEquals((long) result.getPublishedDate(), 1386543600000L);
        assertEquals(result.getDescription(), "Kolejne wydanie tej cenionej książki zostało zaktualizowane o wszystkie nowości, które pojawiły się w wersji 7 platformy Java Standard Edition. W trakcie lektury poznasz składnię języka oraz wszystkie istotne kwestie związane z programowaniem w Javie. Zrozumiesz założenia programowania obiektowego, nauczysz się korzystać z interfejsów oraz obsługiwać wyjątki. Przekonasz się również, jakie ułatwienia w tym zakresie oferuje Java 7 obsługa wielu wyjątków w ramach jednego bloku catch to tylko czubek góry lodowej.");
        assertEquals((int) result.getPageCount(), 864);
        assertEquals(result.getThumbnailUrl(), "http://books.google.com/books/content?id=UEdjAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
        assertEquals(result.getLanguage(), "pl");
        assertEquals(result.getPreviewLink(), "http://books.google.pl/books?id=UEdjAgAAQBAJ&pg=PA852&dq=java&hl=&cd=4&source=gbs_api");
        assertNotNull(result.getAuthors());
        assertEquals(result.getAuthors().size(), 2);
        assertEquals(result.getAuthors().get(0), "Cay S. Horstmann");
        assertEquals(result.getAuthors().get(1), "Gary Cornell");
        assertNotNull(result.getCategories());
        assertEquals(result.getCategories().size(), 1);
        assertEquals(result.getCategories().get(0), "Computers");
    }

    @Test
    public void test_GetBooksByCategory_NotFound() {
        List<BookModel> result = new BooksManager().getBooksByCategory("notexisting");
        assertNotNull(result);
        assertEquals(result.size(), 0);
    }

    @Test
    public void test_GetBooksByCategory_FoundTwo() {
        List<BookModel> result = new BooksManager().getBooksByCategory("Java");
        assertNotNull(result);
        assertEquals(result.size(), 2);

        BookModel first = result.get(0);
        BookModel second = result.get(1);

        assertEquals(first.getIsbn(), "9788324677658");
        assertEquals(first.getTitle(), "Java. Techniki zaawansowane. Wydanie IX");
        assertNull(first.getSubtitle());
        assertEquals(first.getPublisher(), "Helion");
        assertEquals((long) first.getPublishedDate(), 1386543600000L);
        assertEquals(first.getDescription(), "Dziewiąte wydanie bestsellerowej pozycji Java. Techniki zaawansowane zostało zaktualizowane i uzupełnione o nowinki z najnowszej wersji języka Java oznaczonej numerem 7. W trakcie lektury dowiesz się, jak wydajnie korzystać ze strumieni, wyrażeń regularnych oraz baz danych. Java 7 to całkowicie nowy, mocno rozbudowany dostęp do plików opis wszystkich niuansów znajdziesz w tej publikacji. Co jeszcze? Tworzenie aplikacji dla różnych języków i lokalizacji, zaawansowane wykorzystanie biblioteki Swing oraz dystrybucja stworzonych aplikacji. To tylko niektóre z zagadnień poruszonych w tej wyjątkowej książce, która musi się znaleźć na półce każdego programisty języka Java.");
        assertEquals((int) first.getPageCount(), 992);
        assertEquals(first.getThumbnailUrl(), "http://books.google.com/books/content?id=mVNjAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
        assertEquals(first.getLanguage(), "pl");
        assertEquals(first.getPreviewLink(), "http://books.google.pl/books?id=mVNjAgAAQBAJ&printsec=frontcover&dq=java&hl=&cd=5&source=gbs_api");
        assertNotNull(first.getAuthors());
        assertEquals(first.getAuthors().size(), 2);
        assertEquals(first.getAuthors().get(0), "Cay S. Horstmann");
        assertEquals(first.getAuthors().get(1), "Gary Cornell");
        assertNotNull(first.getCategories());
        assertEquals(first.getCategories().size(), 2);
        assertEquals(first.getCategories().get(0), "Java");
        assertEquals(first.getCategories().get(1), "Computers");

        assertEquals(second.getIsbn(), "9780131002876");
        assertEquals(second.getTitle(), "Thinking in Java");
        assertNull(second.getSubtitle());
        assertEquals(second.getPublisher(), "Prentice Hall Professional");
        assertEquals((long) second.getPublishedDate(), 1041375600000L);
        assertEquals(second.getDescription(), "An overview of the programming language's fundamentals covers syntax, initialization, implementation, classes, error handling, objects, applets, multiple threads, projects, and network programming.");
        assertEquals((int) second.getPageCount(), 1119);
        assertEquals(second.getThumbnailUrl(), "http://books.google.com/books/content?id=Ql6QgWf6i7cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
        assertEquals(second.getLanguage(), "en");
        assertEquals(second.getPreviewLink(), "http://books.google.pl/books?id=Ql6QgWf6i7cC&printsec=frontcover&dq=java&hl=&cd=7&source=gbs_api");
        assertNotNull(second.getAuthors());
        assertEquals(second.getAuthors().size(), 1);
        assertEquals(second.getAuthors().get(0), "Bruce Eckel");
        assertNotNull(second.getCategories());
        assertEquals(second.getCategories().size(), 2);
        assertEquals(second.getCategories().get(0), "Computers");
        assertEquals(second.getCategories().get(1), "Java");
    }

    @Test
    public void test_GetBooksByCategory_FoundOne() {
        List<BookModel> result = new BooksManager().getBooksByCategory("Great Britain");
        assertNotNull(result);
        assertEquals(result.size(), 1);

        BookModel book = result.get(0);

        assertEquals(book.getIsbn(), "y6QNAAAAQAAJ");
        assertEquals(book.getTitle(), "Java");
        assertEquals(book.getSubtitle(), "Or, How to Manage a Colony. Showing a Practical Solution of the Questions Now Affecting British India");
        assertNull(book.getPublisher());
        assertEquals((long) book.getPublishedDate(), -3439674000000L);
        assertNull(book.getDescription());
        assertNull(book.getPageCount());
        assertEquals(book.getThumbnailUrl(), "http://books.google.com/books/content?id=y6QNAAAAQAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
        assertEquals(book.getLanguage(), "en");
        assertEquals(book.getPreviewLink(), "http://books.google.pl/books?id=y6QNAAAAQAAJ&pg=PP1&dq=java&hl=&cd=6&source=gbs_api");
        assertNotNull(book.getAuthors());
        assertEquals(book.getAuthors().size(), 1);
        assertEquals(book.getAuthors().get(0), "James William Bayley Money");
        assertNotNull(book.getCategories());
        assertEquals(book.getCategories().size(), 1);
        assertEquals(book.getCategories().get(0), "Great Britain");
    }

    @Test
    public void test_GetAuthorsByRatingDesc() {
        List<AuthorRatingModel> result = new BooksManager().getAuthorsByRatingDesc();
        assertNotNull(result);
        assertEquals(result.size(), 15);

        String[] expectedAuthorsArray = new String[]{"BUYYA", "Bert Bates", "Jain Pravin", "Kathy Sierra", "Sir Thomas Stamford Raffles", "Bruce Eckel", "Clifford Geertz", "David Flanagan", "Douglas Lea", "Eric Burke", "Kenneth L. Calvert", "Michael J. Donahoo", "Barry Burd", "George Reese", "James William Bayley Money"};
        Double[] expectedRatingArray = new Double[]{5.0, 4.5, 4.5, 4.5, 4.5, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 3.5, 3.5, 1.0};

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expectedAuthorsArray[i], result.get(i).getAuthor());
            assertEquals(expectedRatingArray[i], result.get(i).getAverageRating(), 0.0);
        }
    }
}