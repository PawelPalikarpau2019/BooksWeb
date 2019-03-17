package my.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static String PATH_TO_FILE;

    public static void main(String[] args) {
        if (args != null && args.length > 0)
            PATH_TO_FILE = args[0];

        SpringApplication.run(App.class, args);
    }
}
