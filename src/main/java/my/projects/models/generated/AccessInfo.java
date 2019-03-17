package my.projects.models.generated;

import com.fasterxml.jackson.annotation.*;

public class AccessInfo {
    private Country country;
    private Viewability viewability;
    private boolean embeddable;
    private boolean publicDomain;
    private TextToSpeechPermission textToSpeechPermission;
    private Epub epub;
    private Epub pdf;
    private String webReaderLink;
    private AccessViewStatus accessViewStatus;
    private boolean quoteSharingAllowed;

    @JsonProperty("country")
    public Country getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(Country value) { this.country = value; }

    @JsonProperty("viewability")
    public Viewability getViewability() { return viewability; }
    @JsonProperty("viewability")
    public void setViewability(Viewability value) { this.viewability = value; }

    @JsonProperty("embeddable")
    public boolean getEmbeddable() { return embeddable; }
    @JsonProperty("embeddable")
    public void setEmbeddable(boolean value) { this.embeddable = value; }

    @JsonProperty("publicDomain")
    public boolean getPublicDomain() { return publicDomain; }
    @JsonProperty("publicDomain")
    public void setPublicDomain(boolean value) { this.publicDomain = value; }

    @JsonProperty("textToSpeechPermission")
    public TextToSpeechPermission getTextToSpeechPermission() { return textToSpeechPermission; }
    @JsonProperty("textToSpeechPermission")
    public void setTextToSpeechPermission(TextToSpeechPermission value) { this.textToSpeechPermission = value; }

    @JsonProperty("epub")
    public Epub getEpub() { return epub; }
    @JsonProperty("epub")
    public void setEpub(Epub value) { this.epub = value; }

    @JsonProperty("pdf")
    public Epub getPDF() { return pdf; }
    @JsonProperty("pdf")
    public void setPDF(Epub value) { this.pdf = value; }

    @JsonProperty("webReaderLink")
    public String getWebReaderLink() { return webReaderLink; }
    @JsonProperty("webReaderLink")
    public void setWebReaderLink(String value) { this.webReaderLink = value; }

    @JsonProperty("accessViewStatus")
    public AccessViewStatus getAccessViewStatus() { return accessViewStatus; }
    @JsonProperty("accessViewStatus")
    public void setAccessViewStatus(AccessViewStatus value) { this.accessViewStatus = value; }

    @JsonProperty("quoteSharingAllowed")
    public boolean getQuoteSharingAllowed() { return quoteSharingAllowed; }
    @JsonProperty("quoteSharingAllowed")
    public void setQuoteSharingAllowed(boolean value) { this.quoteSharingAllowed = value; }
}
