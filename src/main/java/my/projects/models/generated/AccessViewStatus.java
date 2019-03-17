package my.projects.models.generated;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum AccessViewStatus {
    FULL_PUBLIC_DOMAIN, NONE, SAMPLE;

    @JsonValue
    public String toValue() {
        switch (this) {
        case FULL_PUBLIC_DOMAIN: return "FULL_PUBLIC_DOMAIN";
        case NONE: return "NONE";
        case SAMPLE: return "SAMPLE";
        }
        return null;
    }

    @JsonCreator
    public static AccessViewStatus forValue(String value) throws IOException {
        if (value.equals("FULL_PUBLIC_DOMAIN")) return FULL_PUBLIC_DOMAIN;
        if (value.equals("NONE")) return NONE;
        if (value.equals("SAMPLE")) return SAMPLE;
        throw new IOException("Cannot deserialize AccessViewStatus");
    }
}
