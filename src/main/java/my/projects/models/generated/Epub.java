package my.projects.models.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Epub {
    private boolean isAvailable;
    private String acsTokenLink;
    private String downloadLink;

    @JsonProperty("isAvailable")
    public boolean getIsAvailable() { return isAvailable; }
    @JsonProperty("isAvailable")
    public void setIsAvailable(boolean value) { this.isAvailable = value; }

    @JsonProperty("acsTokenLink")
    public String getAcsTokenLink() { return acsTokenLink; }
    @JsonProperty("acsTokenLink")
    public void setAcsTokenLink(String value) { this.acsTokenLink = value; }

    @JsonProperty("downloadLink")
    public String getDownloadLink() { return downloadLink; }
    @JsonProperty("downloadLink")
    public void setDownloadLink(String value) { this.downloadLink = value; }
}
