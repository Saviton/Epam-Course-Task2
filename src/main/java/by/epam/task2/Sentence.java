package by.epam.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Sentence implements Component {

    private List<Component> components;

    private static final Logger LOGGER = LoggerFactory.getLogger(Sentence.class);

    public Sentence() {
    }

    public Sentence(List<Component> components) {
        this.components = components;
        LOGGER.info("was created: " + this.print());
    }

    public static List<Component> stringToComponents(String line) {
        List<Component> components = new ArrayList<>();

        String regex = "[\\p{L}\\p{M}\\p{N}]+(?:\\p{P}[\\p{L}\\p{M}\\p{N}]+)*|[\\p{P}\\p{S}]";

        String[] wordsAndPunctuation = Pattern.compile(regex).
                matcher(line).results().
                map(MatchResult::group).
                toArray(String[]::new);

        for (String s : wordsAndPunctuation) {
            for (Punctuation punctuation : EnumSet.range(Punctuation.EXCLAMATION, Punctuation.BACKSLASH)) {
                if (s.equals(punctuation.getValue())) {
                    components.add(punctuation);
                    break;
                }
                if (Punctuation.BACKSLASH.equals(punctuation)) {
                    Word word = new Word(s);
                    components.add(word);
                }
            }
        }

        return components;
    }

    public List<Component> getWords() {
        List<Component> words = new ArrayList<>();

        for (Component component : components)
            if (component instanceof Word)
                words.add(component);

        if (words.size() == 0)
            LOGGER.info("Words returned as an empty list!");
        return words;
    }

    public List<Component> getPunctuation() {
        List<Component> punctuations = new ArrayList<>();

        for (Component component : components)
            if (component instanceof Punctuation)
                punctuations.add(component);

        return punctuations;
    }

    @Override
    public String print() {
        String result = components.get(0).print();
        Component currentComponent;

        for (int i = 1; i < components.size(); i++) {
            currentComponent = components.get(i);
            if (currentComponent instanceof Word)
                result += " " + currentComponent.print();
            else
                result += currentComponent.print();
        }

        return result;
    }
}
