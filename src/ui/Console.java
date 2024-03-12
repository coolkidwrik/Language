package ui;
import model.App;
import model.Definition;
import model.Lang;

import java.util.Scanner;

public class Console {
    // TODO: implement
    // fields
    //////////////////////////////
    private App app;

    // constructor
    //////////////////////////////

    // EFFECTS: creates a new console
    public Console() {
        app = new App();
        runConsole();
    }

    // methods
    //////////////////////////////

    //EFFECTS: runs the console
    private void runConsole() {
        boolean running = true;
        System.out.println("Welcome to the language app! (name is a work in progress)");
        while (running) {
            printMenu();
            String input = getUserInput("Enter a number");
            if (input.equals("1")) {
                AddLanguage();
            } else if (input.equals("2")) {
                RemoveLanguage();
            } else if (input.equals("3")) {
                ViewLanguages();
                getUserInput("Press enter to return to the menu");
                System.out.println("\n");
            } else if (input.equals("4")) {
                ViewALanguage();
            } else if (input.equals("5")) {
                // LoadLanguages();
                continue;
            } else if (input.equals("6")) {
                // SaveLanguages();
                continue;
            } else if (input.equals("7")) {
                running = false;
            }
            else {
                printError("Invalid input. Try again\n");
            }
        }
        System.out.println("\nGoodbye!");
    }


    //EFFECTS: prints the menu
    private void printMenu() {
        System.out.println("1. Add a language"); // add a language
        System.out.println("2. Remove a language"); // remove a language
        System.out.println("3. View all languages"); // view list of all currently added languages
        System.out.println("4. View a language"); // view a language
        System.out.println("5. Load languages"); // load languages from file
        System.out.println("6. Save languages"); // save languages to file
        System.out.println("7. Quit"); // quit
    }

    //EFFECTS: gets user input for language name to add
    private void AddLanguage() {
        String langName = getUserInput("Enter the name of the language");
        app.addLanguage(langName);
        System.out.println("\nLanguage " + langName + " added\n");
    }

    //EFFECTS: gets user input for language name to remove
    private void RemoveLanguage() {
        String langName = getUserInput("Enter the name of the language");
        app.removeLanguage(langName);
        System.out.println("Language " + langName + " removed\n");
    }

    //EFFECTS: prints the list of languages
    private void ViewLanguages() {
        String[] languages = app.viewLanguages();
        int count = 1;
        for (String lang : languages) {
            System.out.println(count + ". "+ lang);
            count++;
        }
    }

    //EFFECTS: gets user input for language to view
    private void ViewALanguage() {
        ViewLanguages();
        String langName = getUserInput("Enter language from the list");
        Lang lang = app.getLanguages().get(langName);
        printViewLanguageMenu();
        String input = getUserInput("Enter a number");
        if (input.equals("1")) {
            addWordProcess(lang);
        } else if (input.equals("2")) {
            // RemoveWord(langName);
        } else if (input.equals("3")) {
            viewWords(lang);
        } else if (input.equals("4")) {
            // ViewWord(langName);
        } else if (input.equals("5")) {
            return;
        } else {
            printError("Invalid input");
        }
        ViewALanguage();
    }

    //EFFECTS: prints the menu for the language (option 4)
    private void printViewLanguageMenu() {
        System.out.println("1. Add a word");
        System.out.println("2. Remove a word");
        System.out.println("3. View all words");
        System.out.println("4. View a word"); // this should also give the option to edit the word
        System.out.println("5. Back");
    }

    //EFFECTS: adds a word to the language
    private void addWordProcess(Lang lang) {
        String word = getUserInput("Enter the word to add to the language");
        String translation = getUserInput("Enter the translation of the word");
        String meaning = getUserInput("Enter the definition of the word");
        String pronunciation = getUserInput("Enter the pronunciation of the word");
        Definition def = app.createDefinition(meaning, pronunciation);

        lang.addWord(word, translation, def);

        String exampleQuestion = getUserInput("Do you want to add an example sentence? (y/n)");
        addExampleProcess(def, exampleQuestion);
    }

    //EFFECTS: adds an example to the definition
    private void addExampleProcess(Definition def, String exampleQuestion) {
        if (exampleQuestion.equals("y")) {
            String example = getUserInput("Enter the example sentence");
            String additionalInfo = getUserInput("Enter additional information");
            def.addExample(example, additionalInfo);
            String another = getUserInput("Do you want to add another example sentence? (y/n)");
            addExampleProcess(def, another);
        } else if (exampleQuestion.equals("n")){
            // do nothing
        } else {
            printError("Invalid input. Try again\n");
            String tryAgain = getUserInput("Do you want to add an example sentence? (y/n)");
            addExampleProcess(def, tryAgain);
        }
    }

    //EFFECTS: removes a word from the language
    private void removeWordProcess(Lang lang) {
        // TODO: implement

    }

    //EFFECTS: prints the list of words in the language
    private void viewWords(Lang lang) {
        String[] words = lang.viewWords();
        int count = 1;
        for (String word : words) {
            System.out.println(count + ". " + word);
            count++;
        }
        getUserInput("Press enter to return to "+ lang +" menu");
        System.out.println("\n");
    }

    //EFFECTS: prints the error message
    private void printError(String message) {
        System.out.println("Error: " + message);
    }

    //EFFECTS: gets user input
    private String getUserInput(String text) {
        System.out.print(text + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
