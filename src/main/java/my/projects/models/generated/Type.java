package my.projects.models.generated;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Type {
    ISBN_10, ISBN_13, OTHER;

    @JsonValue
    public String toValue() {
        switch (this) {
        case ISBN_10: return "ISBN_10";
        case ISBN_13: return "ISBN_13";
        case OTHER: return "OTHER";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("ISBN_10")) return ISBN_10;
        if (value.equals("ISBN_13")) return ISBN_13;
        if (value.equals("OTHER")) return OTHER;
        throw new IOException("Cannot deserialize Type");
    }
}
