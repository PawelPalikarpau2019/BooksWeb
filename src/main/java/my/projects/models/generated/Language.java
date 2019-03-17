package my.projects.models.generated;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Language {
    EN, PL;

    @JsonValue
    public String toValue() {
        switch (this) {
        case EN: return "en";
        case PL: return "pl";
        }
        return null;
    }

    @JsonCreator
    public static Language forValue(String value) throws IOException {
        if (value.equals("en")) return EN;
        if (value.equals("pl")) return PL;
        throw new IOException("Cannot deserialize Language");
    }
}
