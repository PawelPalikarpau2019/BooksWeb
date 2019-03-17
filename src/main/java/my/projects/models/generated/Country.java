package my.projects.models.generated;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Country {
    PL;

    @JsonValue
    public String toValue() {
        switch (this) {
        case PL: return "PL";
        }
        return null;
    }

    @JsonCreator
    public static Country forValue(String value) throws IOException {
        if (value.equals("PL")) return PL;
        throw new IOException("Cannot deserialize Country");
    }
}
