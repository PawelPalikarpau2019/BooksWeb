package my.projects.models.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PanelizationSummary {
    private boolean containsEpubBubbles;
    private boolean containsImageBubbles;

    @JsonProperty("containsEpubBubbles")
    public boolean getContainsEpubBubbles() { return containsEpubBubbles; }
    @JsonProperty("containsEpubBubbles")
    public void setContainsEpubBubbles(boolean value) { this.containsEpubBubbles = value; }

    @JsonProperty("containsImageBubbles")
    public boolean getContainsImageBubbles() { return containsImageBubbles; }
    @JsonProperty("containsImageBubbles")
    public void setContainsImageBubbles(boolean value) { this.containsImageBubbles = value; }
}
