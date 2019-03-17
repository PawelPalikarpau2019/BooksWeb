package my.projects.models.generated;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Kind {
    BOOKS_VOLUME;

    @JsonValue
    public String toValue() {
        switch (this) {
        case BOOKS_VOLUME: return "books#volume";
        }
        return null;
    }

    @JsonCreator
    public static Kind forValue(String value) throws IOException {
        if (value.equals("books#volume")) return BOOKS_VOLUME;
        throw new IOException("Cannot deserialize Kind");
    }
}
