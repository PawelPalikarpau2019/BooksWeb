package my.projects.models.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageLinks {
    private String smallThumbnail;
    private String thumbnail;

    @JsonProperty("smallThumbnail")
    public String getSmallThumbnail() { return smallThumbnail; }
    @JsonProperty("smallThumbnail")
    public void setSmallThumbnail(String value) { this.smallThumbnail = value; }

    @JsonProperty("thumbnail")
    public String getThumbnail() { return thumbnail; }
    @JsonProperty("thumbnail")
    public void setThumbnail(String value) { this.thumbnail = value; }
}
