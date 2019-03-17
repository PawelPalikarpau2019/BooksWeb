package my.projects.models.generated;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum MaturityRating {
    NOT_MATURE;

    @JsonValue
    public String toValue() {
        switch (this) {
        case NOT_MATURE: return "NOT_MATURE";
        }
        return null;
    }

    @JsonCreator
    public static MaturityRating forValue(String value) throws IOException {
        if (value.equals("NOT_MATURE")) return NOT_MATURE;
        throw new IOException("Cannot deserialize MaturityRating");
    }
}
