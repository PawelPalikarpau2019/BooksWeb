package my.projects.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.projects.models.generated.Books;

import java.io.*;
import java.nio.charset.Charset;

class JsonFileParser {
    Books selectAndConvertJsonFile(String usersPathToFile) {
        BufferedReader reader = null;

        if (usersPathToFile != null && !usersPathToFile.trim().equalsIgnoreCase("")) {
            File usersFile = new File(usersPathToFile);
            if(!usersFile.exists())
                throw new RuntimeException("The file does not exist");
            else if(usersFile.isDirectory())
                throw new RuntimeException("Path to a folder has been provided. Please provide path to a file!");

            try {
                reader = new BufferedReader(new FileReader(usersFile));
            } catch (FileNotFoundException alreadyThrown) { }
        } else {
            System.out.println("You did not provide any path to file. The default file will be used.");
            InputStream in = getClass().getResourceAsStream("/books.json");
            reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        }

        try {
            return new ObjectMapper().readValue(reader, Books.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
