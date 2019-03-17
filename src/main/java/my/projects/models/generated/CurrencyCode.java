package my.projects.models.generated;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum CurrencyCode {
    PLN;

    @JsonValue
    public String toValue() {
        switch (this) {
        case PLN: return "PLN";
        }
        return null;
    }

    @JsonCreator
    public static CurrencyCode forValue(String value) throws IOException {
        if (value.equals("PLN")) return PLN;
        throw new IOException("Cannot deserialize CurrencyCode");
    }
}
