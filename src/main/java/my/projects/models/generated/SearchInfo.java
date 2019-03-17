package my.projects.models.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchInfo {
    private String textSnippet;

    @JsonProperty("textSnippet")
    public String getTextSnippet() { return textSnippet; }
    @JsonProperty("textSnippet")
    public void setTextSnippet(String value) { this.textSnippet = value; }
}
