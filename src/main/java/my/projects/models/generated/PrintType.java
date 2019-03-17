package my.projects.models.generated;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum PrintType {
    BOOK;

    @JsonValue
    public String toValue() {
        switch (this) {
        case BOOK: return "BOOK";
        }
        return null;
    }

    @JsonCreator
    public static PrintType forValue(String value) throws IOException {
        if (value.equals("BOOK")) return BOOK;
        throw new IOException("Cannot deserialize PrintType");
    }
}
