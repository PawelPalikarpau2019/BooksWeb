package my.projects.models.generated;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Books {
    private String requestedURL;
    private List<Item> items;

    @JsonProperty("requestedUrl")
    public String getRequestedURL() { return requestedURL; }
    @JsonProperty("requestedUrl")
    public void setRequestedURL(String value) { this.requestedURL = value; }

    @JsonProperty("items")
    public List<Item> getItems() { return items; }
    @JsonProperty("items")
    public void setItems(List<Item> value) { this.items = value; }
}
