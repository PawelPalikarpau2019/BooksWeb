package my.projects.models.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReadingModes {
    private boolean text;
    private boolean image;

    @JsonProperty("text")
    public boolean getText() { return text; }
    @JsonProperty("text")
    public void setText(boolean value) { this.text = value; }

    @JsonProperty("image")
    public boolean getImage() { return image; }
    @JsonProperty("image")
    public void setImage(boolean value) { this.image = value; }
}
