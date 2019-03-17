package my.projects.component;

import my.projects.models.BookModel;
import my.projects.models.generated.IndustryIdentifier;
import my.projects.models.generated.Item;
import my.projects.models.generated.Type;
import my.projects.models.generated.VolumeInfo;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
class ConvertManager {
    BookModel convertToBook(Item item) {
        if (item == null)
            return null;

        VolumeInfo volumeInfo = item.getVolumeInfo();

        BookModel result = new BookModel();

        String isbn = getISBN(volumeInfo);

        result.setIsbn(isbn != null ? isbn : item.getID());
        result.setTitle(volumeInfo.getTitle());
        result.setSubtitle(volumeInfo.getSubtitle());
        result.setPublisher(volumeInfo.getPublisher());
        result.setPublishedDate(getUnixTimestamp(volumeInfo.getPublishedDate()));
        result.setDescription(volumeInfo.getDescription());
        result.setPageCount((volumeInfo.getPageCount() != null) ? volumeInfo.getPageCount().intValue() : null);
        result.setThumbnailUrl((volumeInfo.getImageLinks() != null) ? volumeInfo.getImageLinks().getThumbnail() : null);
        result.setLanguage(volumeInfo.getLanguage().toValue());
        result.setPreviewLink(volumeInfo.getPreviewLink());
        result.setPreviewLink(volumeInfo.getPreviewLink());
        result.setAuthors(volumeInfo.getAuthors());
        result.setCategories(volumeInfo.getCategories());

        return result;
    }

    private String getISBN(VolumeInfo volumeInfo) {
        String result = null;

            IndustryIdentifier ii = volumeInfo.getIndustryIdentifiers()
                    .stream()
                    .filter(x -> x.getType().equals(Type.ISBN_13))
                    .findFirst()
                    .orElse(null);

            if (ii != null) {
                result = ii.getIdentifier();
            }
        return result;
    }

    private Long getUnixTimestamp(String dateString) {
        if (dateString == null || dateString.trim().equals(""))
            return null;

        Pattern firstRegex = Pattern.compile("[\\d]{4}$");
        Pattern secondRegex = Pattern.compile("[\\d]{4}[-]([\\d]{2})[-]([\\d]{2})$");

        Matcher firstMather = firstRegex.matcher(dateString);
        Matcher secondMather = secondRegex.matcher(dateString);

        java.text.DateFormat dateFormat = null;

        Date result = null;
        if (firstMather.matches()) {
            dateFormat = new java.text.SimpleDateFormat("yyyy");
        } else if (secondMather.matches()) {
            dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        } else {
            System.out.println("Unknown date format in field item.volumeInfo.publishedTime");
        }

        if (dateFormat == null) return null;

        try {
            result = dateFormat.parse(dateString);
        } catch (java.text.ParseException e) {
            System.out.println("Unsuccessful parsing of date on item.volumeInfo.publishedTime");
        }
        return result != null ? result.getTime() : null;
    }
}
