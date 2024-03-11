package model;

/*
    stores definitions for a word
*/
public class Definition {
    // TODO: go over implementation
    private final String definition;
    private final String[] examples;

    //EFFECTS: constructs a definition with a definition and examples
    public Definition(String definition, String[] examples) {
        this.definition = definition;
        this.examples = examples;
    }

    //EFFECTS: returns the definition
    public String getDefinition() {
        return definition;
    }

    //EFFECTS: returns the examples
    public String[] getExamples() {
        return examples;
    }

    //EFFECTS: returns the definition and examples
    public String toString() {
        return definition + " " + examples;
    }

    //EFFECTS: returns the definition and examples as a string
    public String toFile() {
        return definition + " " + examples;
    }
}
