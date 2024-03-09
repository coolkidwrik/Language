package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
//inspiration for JsonReader in link
//EFFECTS: reads from json file to recover previous user data
public class JsonReader {

    private String file;

    //EFFECTS: constructs a reader to read from the file
    public JsonReader(String file) {
        this.file = file;
    }

    //EFFECTS: reads file as string and returns it
    private String readFile(String file) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(file), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

}
