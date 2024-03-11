package model;
import java.util.HashMap;

 /*
 This class will be run by UI classes to perform operations on the languages
 additionally, this class will have a dictionary of all languages added so far
  */
public class App {
    private final HashMap<String, Lang> languages;

    // Constructor
    //////////////////////////

    // EFFECTS: constructs an app with a dictionary of languages
     public App() {
         this.languages = new HashMap<>();
     }

     // Methods
     //////////////////////////

    // MODIFIES: this
    // EFFECTS: adds a language to the app
    public void addLanguage(String langName) {
        Lang lang = new Lang(langName);
        languages.put(langName, lang);
    }

    // MODIFIES: this
    // EFFECTS: removes a language from the app
    public void removeLanguage(String langName) {
        languages.remove(langName);
    }

    // EFFECTS: returns a list of all languages in the app
    public String[] viewLanguages() {
        return languages.keySet().toArray(new String[0]);
    }

    // EFFECTS: returns the languages in the app
    public HashMap<String, Lang> getLanguages() {
        return languages;
    }
 }
