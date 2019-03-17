package my.projects.component;

import my.projects.models.BookModel;
import my.projects.models.generated.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SpringBootTest
public class ConvertManagerTest {

    private static ConvertManager converter;

    @BeforeClass
    public static void setUp()
    {
        converter = new ConvertManager();
    }

    @AfterClass
    public static void tearDown() {
        converter = null;
    }

    @Test
    public void test_ConvertToBook_NullIncoming() {
        BookModel result = converter.convertToBook(null);
        assertNull(result);
    }

    @Test
    public void test_ConvertToBook_Success_001() {
        Item item = new Item();

        VolumeInfo vi = new VolumeInfo();

        IndustryIdentifier ii = new IndustryIdentifier();
        ii.setType(Type.ISBN_13);
        ii.setIdentifier("9781592432172");

        ImageLinks il = new ImageLinks();
        il.setThumbnail("http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");

        vi.setIndustryIdentifiers(Collections.singletonList(ii));
        vi.setTitle("A Hypervista of the Java Landscape");
        vi.setPublisher("InfoStrategist.com");
        vi.setImageLinks(il);
        vi.setLanguage(Language.EN);
        vi.setPreviewLink("http://books.google.pl/books?id=7tkN1CYzn2cC&pg=PP1&dq=java&hl=&cd=1&source=gbs_api");

        item.setVolumeInfo(vi);

        BookModel result = converter.convertToBook(item);

        assertNotNull(result);

        assertEquals(result.getIsbn(), "9781592432172");
        assertEquals(result.getTitle(), "A Hypervista of the Java Landscape");
        assertNull(result.getSubtitle());
        assertEquals(result.getPublisher(), "InfoStrategist.com");
        assertNull(result.getPublishedDate());
        assertNull(result.getDescription());
        assertNull(result.getPageCount());
        assertEquals(result.getThumbnailUrl(), "http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
        assertEquals(result.getLanguage(), "en");
        assertEquals(result.getPreviewLink(), "http://books.google.pl/books?id=7tkN1CYzn2cC&pg=PP1&dq=java&hl=&cd=1&source=gbs_api");
        assertNull(result.getAuthors());
        assertNull(result.getCategories());
    }

    @Test
    public void test_ConvertToBook_Success_002() {
        Item item = new Item();
        item.setID("y6QNAAAAQAAJ");

        VolumeInfo vi = new VolumeInfo();

        ImageLinks il = new ImageLinks();
        il.setThumbnail("http://books.google.com/books/content?id=y6QNAAAAQAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");

        vi.setIndustryIdentifiers(new LinkedList<>());
        vi.setTitle("Java");
        vi.setSubtitle("Or, How to Manage a Colony. Showing a Practical Solution of the Questions Now Affecting British India");
        vi.setPublishedDate("1861");
        vi.setImageLinks(il);
        vi.setLanguage(Language.EN);
        vi.setPreviewLink("http://books.google.pl/books?id=y6QNAAAAQAAJ&pg=PP1&dq=java&hl=&cd=6&source=gbs_api");
        vi.setAuthors(Collections.singletonList("James William Bayley Money"));
        vi.setCategories(Collections.singletonList("Great Britain"));

        item.setVolumeInfo(vi);

        BookModel result = converter.convertToBook(item);

        assertNotNull(result);

        assertEquals(result.getIsbn(), "y6QNAAAAQAAJ");
        assertEquals(result.getTitle(), "Java");
        assertEquals(result.getSubtitle(), "Or, How to Manage a Colony. Showing a Practical Solution of the Questions Now Affecting British India");
        assertNull(result.getPublisher());
        assertEquals((long) result.getPublishedDate(), -3439674000000L);
        assertNull(result.getDescription());
        assertNull(result.getPageCount());
        assertEquals(result.getThumbnailUrl(), "http://books.google.com/books/content?id=y6QNAAAAQAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
        assertEquals(result.getLanguage(), "en");
        assertEquals(result.getPreviewLink(), "http://books.google.pl/books?id=y6QNAAAAQAAJ&pg=PP1&dq=java&hl=&cd=6&source=gbs_api");
        assertNotNull(result.getAuthors());
        assertEquals(result.getAuthors().size(), 1);
        assertEquals(result.getAuthors().get(0), "James William Bayley Money");
        assertNotNull(result.getCategories());
        assertEquals(result.getCategories().size(), 1);
        assertEquals(result.getCategories().get(0), "Great Britain");
    }
}