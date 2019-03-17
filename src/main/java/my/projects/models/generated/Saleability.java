package my.projects.models.generated;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Saleability {
    FOR_SALE, FREE, NOT_FOR_SALE;

    @JsonValue
    public String toValue() {
        switch (this) {
        case FOR_SALE: return "FOR_SALE";
        case FREE: return "FREE";
        case NOT_FOR_SALE: return "NOT_FOR_SALE";
        }
        return null;
    }

    @JsonCreator
    public static Saleability forValue(String value) throws IOException {
        if (value.equals("FOR_SALE")) return FOR_SALE;
        if (value.equals("FREE")) return FREE;
        if (value.equals("NOT_FOR_SALE")) return NOT_FOR_SALE;
        throw new IOException("Cannot deserialize Saleability");
    }
}
