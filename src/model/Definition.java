package model;

import java.util.HashMap;

/*
    stores definitions for a word in a language
    specifics of a language like the pronunciation and examples in sentences
    e.g: "moon":
            The heavenly body that illuminates the night; a celestial body that is in orbit around the earth.
            つき　(tsu-ki)
            [月がきれいですね, (the moon is beautiful tonight)]
            [月が大きいですね, (the moon is big tonight)]
*/
public class Definition {
    private final String definition;

    private final String pronunciation;

    // stores examples of the word in sentences along with additional information
    // structure is {example sentence : additional information}
    // additional information could be the translation of the sentence or additional pronunciation
    // (in the case of languages like japanese where the pronunciation can change based on the sentence it is in)
    private final HashMap<String, String> examples;

    //EFFECTS: constructs a definition with a definition and examples
    public Definition(String definition, String pronunciation, HashMap<String, String> examples) {
        this.definition = definition;
        this.pronunciation = pronunciation;
        this.examples = examples;
    }

    // getters
    //////////////////////////

    //EFFECTS: returns the definition
    public String getDefinition() {
        return definition;
    }

    //EFFECTS: returns the pronunciation
    public String getPronunciation() {
        return pronunciation;
    }

    //EFFECTS: returns the examples
    public HashMap<String, String> getExamples() {
        return examples;
    }

    // methods
    //////////////////////////

    //EFFECTS: returns the definition and examples
    public String toString() {
        return definition + "\n" + pronunciation + "\n" + examplesToString();
    }

    //EFFECTS: returns examples and additional information in a string
    public String examplesToString() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<String, String> entry : examples.entrySet()) {
            sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
