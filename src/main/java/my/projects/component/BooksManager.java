package my.projects.component;

import my.projects.App;
import my.projects.models.AuthorRatingModel;
import my.projects.models.BookModel;
import my.projects.models.generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BooksManager {

    private ConvertManager converter;
    
    private Books books;

    @Autowired
    public BooksManager() {
        books = new JsonFileParser().selectAndConvertJsonFile(App.PATH_TO_FILE);
        this.converter = new ConvertManager();
    }

    public BookModel getBookByID(String ID) {
        BookModel result = null;
        for (Item book : books.getItems()) {
            List<IndustryIdentifier> iis = book.getVolumeInfo().getIndustryIdentifiers();
            IndustryIdentifier ii = iis.stream()
                    .filter(x -> x.getType().equals(Type.ISBN_13))
                    .filter(x -> x.getIdentifier().equalsIgnoreCase(ID))
                    .findFirst().orElse(null);

            if (ii != null || book.getID().equalsIgnoreCase(ID)) {
                result = converter.convertToBook(book);
                break;
            }
        }
        return result;
    }

    public List<BookModel> getBooksByCategory(String category) {
        List<BookModel> result = new LinkedList<>();
        for (Item book : books.getItems()) {
            if (book.getVolumeInfo().getCategories() != null) {
                boolean foundCategory = book.getVolumeInfo().getCategories()
                        .stream()
                        .anyMatch(x -> x.equals(category));

                if (foundCategory) {
                    BookModel convertedBook = converter.convertToBook(book);
                    if(convertedBook != null)
                        result.add(convertedBook);
                }
            }
        }
        return result;
    }

    public List<AuthorRatingModel> getAuthorsByRatingDesc() {
        Map<String, List<Double>> authorsRatingMap = new HashMap<>();

        for (Item book : books.getItems()) {
            VolumeInfo volumeInfo = book.getVolumeInfo();
            if (volumeInfo.getRatingsCount() != null &&
                    volumeInfo.getAuthors() != null &&
                    volumeInfo.getAuthors().size() > 0) {
                volumeInfo.getAuthors()
                        .forEach(author -> authorsRatingMap.computeIfAbsent(author, k -> new LinkedList<>())
                                .add(book.getVolumeInfo().getAverageRating()));
            }
        }

        return getAuthorsSortedDescendingByRating(authorsRatingMap);
    }

    private List<AuthorRatingModel> getAuthorsSortedDescendingByRating(Map<String, List<Double>> authorsRatingMap) {
        List<AuthorRatingModel> result = new LinkedList<>();
        authorsRatingMap.forEach((k, v) ->
                result.add(new AuthorRatingModel(
                        k, v.stream().mapToDouble(x -> x).summaryStatistics().getAverage()
                )));
        result.sort(Comparator.comparing(AuthorRatingModel::getAverageRating).reversed().thenComparing(AuthorRatingModel::getAuthor));
        return result;
    }
}
