package my.projects.models.generated;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum TextToSpeechPermission {
    ALLOWED, ALLOWED_FOR_ACCESSIBILITY;

    @JsonValue
    public String toValue() {
        switch (this) {
        case ALLOWED: return "ALLOWED";
        case ALLOWED_FOR_ACCESSIBILITY: return "ALLOWED_FOR_ACCESSIBILITY";
        }
        return null;
    }

    @JsonCreator
    public static TextToSpeechPermission forValue(String value) throws IOException {
        if (value.equals("ALLOWED")) return ALLOWED;
        if (value.equals("ALLOWED_FOR_ACCESSIBILITY")) return ALLOWED_FOR_ACCESSIBILITY;
        throw new IOException("Cannot deserialize TextToSpeechPermission");
    }
}
