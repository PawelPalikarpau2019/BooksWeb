package my.projects.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No results found")
public class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
