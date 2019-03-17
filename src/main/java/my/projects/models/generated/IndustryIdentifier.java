package my.projects.models.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IndustryIdentifier {
    private Type type;
    private String identifier;

    @JsonProperty("type")
    public Type getType() { return type; }
    @JsonProperty("type")
    public void setType(Type value) { this.type = value; }

    @JsonProperty("identifier")
    public String getIdentifier() { return identifier; }
    @JsonProperty("identifier")
    public void setIdentifier(String value) { this.identifier = value; }
}
