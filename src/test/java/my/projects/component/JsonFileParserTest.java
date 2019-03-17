package my.projects.component;

import my.projects.models.generated.Books;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class JsonFileParserTest {

    private static JsonFileParser parser;

    @BeforeClass
    public static void setUp() {
        parser = new JsonFileParser();
    }

    @AfterClass
    public static void tearDown() {
        parser = null;
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void test_ConvertDefaultFile_Success() {
        Books result = parser.selectAndConvertJsonFile(null);
        assertNotNull(result);
    }

    @Test
    public void test_ConvertUserFile_Success() {
        Books result = parser.selectAndConvertJsonFile("src/test/resources/books.json");
        assertNotNull(result);
    }

    @Test
    public void test_ConvertUserFile_NotExists_ExpectedException() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("The file does not exist");
        parser.selectAndConvertJsonFile("src/test/resources/notExistingFile.txt");
    }

    @Test
    public void test_ConvertUserFile_IsFolder_ExpectedException() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Path to a folder has been provided. Please provide path to a file!");
        parser.selectAndConvertJsonFile("src/test/resources");
    }

    @Test
    public void test_ConvertUserFile_ParseFailed_ExpectedException() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Unrecognized token 'noneJsonContent': was expecting 'null', 'true', 'false' or NaN");
        parser.selectAndConvertJsonFile("src/test/resources/noneJson.txt");
    }

    @Test
    public void test_ConvertUserFile_EmptyFile_ExpectedException() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("No content to map due to end-of-input");
        parser.selectAndConvertJsonFile("src/test/resources/emptyFile.txt");
    }
}