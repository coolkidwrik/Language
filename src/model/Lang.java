package model;
import java.util.HashMap;

/*
    This class defines a single language. This app can hold many languages.

    per language, use a nested dictionary data structure to keep track of words, translations and definitions.
    {word : {translation : Definition}}
    idea is that one word may have many different translations. for e.g: 月 in japanese can mean "moon" or "month"
    so structure might look like:
    {月 : { moon : moon-Definition,
            month : month-Definition}}
*/
public class Lang {
    // TODO: go over implementation

    // fields
    //////////////////////////
    private final String langName;
    private final HashMap<String, HashMap<String, Definition>> words;

    // constructors
    //////////////////////////

    //EFFECTS: constructs a language with a name
    public Lang(String langName) {
        this.langName = langName;
        words = new HashMap<>();
    }

    // getters
    //////////////////////////

    //EFFECTS: returns the name of the language
    public String getLangName() {
        return langName;
    }

    //EFFECTS: returns the words in the language
    // used for testing
    public HashMap<String, HashMap<String, Definition>> getWords() {
        return words;
    }

    // methods
    //////////////////////////

    //MODIFIES: this
    //EFFECTS: adds a word to the language
    public void addWord(String word, String translation, Definition definition) {
        if (words.containsKey(word)) {
            words.get(word).put(translation, definition);
        } else {
            HashMap<String, Definition> translations = new HashMap<>();
            translations.put(translation, definition);
            words.put(word, translations);
        }
    }

    //REQUIRES: word exists in language
    //EFFECTS: returns the definition of the word
    public Definition getDefinition(String word) {
        return words.get(word).get(word);
    }

    //REQUIRES: word exists in language
    //EFFECTS: returns the translations of the word
    public HashMap<String, Definition> getTranslations(String word) {
        return words.get(word);
    }

    //REQUIRES: word exists in language
    //MODIFIES: this
    //EFFECTS: removes the word from the language
    public void removeWord(String word) {
        words.remove(word);
    }

    //REQUIRES: word exists in language
    //MODIFIES: this
    //EFFECTS: removes the translation from the word
    public void removeTranslation(String word, String translation) {
        words.get(word).remove(translation);
    }
}
