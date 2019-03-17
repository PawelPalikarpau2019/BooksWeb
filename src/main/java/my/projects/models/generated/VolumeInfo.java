package my.projects.models.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VolumeInfo {
    private String title;
    private String publisher;
    private List<IndustryIdentifier> industryIdentifiers;
    private ReadingModes readingModes;
    private PrintType printType;
    private MaturityRating maturityRating;
    private boolean allowAnonLogging;
    private String contentVersion;
    private ImageLinks imageLinks;
    private Language language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;
    private List<String> authors;
    private String publishedDate;
    private String description;
    private Long pageCount;
    private List<String> categories;
    private Double averageRating;
    private Long ratingsCount;
    private PanelizationSummary panelizationSummary;
    private String subtitle;

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("publisher")
    public String getPublisher() { return publisher; }
    @JsonProperty("publisher")
    public void setPublisher(String value) { this.publisher = value; }

    @JsonProperty("industryIdentifiers")
    public List<IndustryIdentifier> getIndustryIdentifiers() { return industryIdentifiers; }
    @JsonProperty("industryIdentifiers")
    public void setIndustryIdentifiers(List<IndustryIdentifier> value) { this.industryIdentifiers = value; }

    @JsonProperty("readingModes")
    public ReadingModes getReadingModes() { return readingModes; }
    @JsonProperty("readingModes")
    public void setReadingModes(ReadingModes value) { this.readingModes = value; }

    @JsonProperty("printType")
    public PrintType getPrintType() { return printType; }
    @JsonProperty("printType")
    public void setPrintType(PrintType value) { this.printType = value; }

    @JsonProperty("maturityRating")
    public MaturityRating getMaturityRating() { return maturityRating; }
    @JsonProperty("maturityRating")
    public void setMaturityRating(MaturityRating value) { this.maturityRating = value; }

    @JsonProperty("allowAnonLogging")
    public boolean getAllowAnonLogging() { return allowAnonLogging; }
    @JsonProperty("allowAnonLogging")
    public void setAllowAnonLogging(boolean value) { this.allowAnonLogging = value; }

    @JsonProperty("contentVersion")
    public String getContentVersion() { return contentVersion; }
    @JsonProperty("contentVersion")
    public void setContentVersion(String value) { this.contentVersion = value; }

    @JsonProperty("imageLinks")
    public ImageLinks getImageLinks() { return imageLinks; }
    @JsonProperty("imageLinks")
    public void setImageLinks(ImageLinks value) { this.imageLinks = value; }

    @JsonProperty("language")
    public Language getLanguage() { return language; }
    @JsonProperty("language")
    public void setLanguage(Language value) { this.language = value; }

    @JsonProperty("previewLink")
    public String getPreviewLink() { return previewLink; }
    @JsonProperty("previewLink")
    public void setPreviewLink(String value) { this.previewLink = value; }

    @JsonProperty("infoLink")
    public String getInfoLink() { return infoLink; }
    @JsonProperty("infoLink")
    public void setInfoLink(String value) { this.infoLink = value; }

    @JsonProperty("canonicalVolumeLink")
    public String getCanonicalVolumeLink() { return canonicalVolumeLink; }
    @JsonProperty("canonicalVolumeLink")
    public void setCanonicalVolumeLink(String value) { this.canonicalVolumeLink = value; }

    @JsonProperty("authors")
    public List<String> getAuthors() { return authors; }
    @JsonProperty("authors")
    public void setAuthors(List<String> value) { this.authors = value; }

    @JsonProperty("publishedDate")
    public String getPublishedDate() { return publishedDate; }
    @JsonProperty("publishedDate")
    public void setPublishedDate(String value) { this.publishedDate = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("pageCount")
    public Long getPageCount() { return pageCount; }
    @JsonProperty("pageCount")
    public void setPageCount(Long value) { this.pageCount = value; }

    @JsonProperty("categories")
    public List<String> getCategories() { return categories; }
    @JsonProperty("categories")
    public void setCategories(List<String> value) { this.categories = value; }

    @JsonProperty("averageRating")
    public Double getAverageRating() { return averageRating; }
    @JsonProperty("averageRating")
    public void setAverageRating(Double value) { this.averageRating = value; }

    @JsonProperty("ratingsCount")
    public Long getRatingsCount() { return ratingsCount; }
    @JsonProperty("ratingsCount")
    public void setRatingsCount(Long value) { this.ratingsCount = value; }

    @JsonProperty("panelizationSummary")
    public PanelizationSummary getPanelizationSummary() { return panelizationSummary; }
    @JsonProperty("panelizationSummary")
    public void setPanelizationSummary(PanelizationSummary value) { this.panelizationSummary = value; }

    @JsonProperty("subtitle")
    public String getSubtitle() { return subtitle; }
    @JsonProperty("subtitle")
    public void setSubtitle(String value) { this.subtitle = value; }
}
