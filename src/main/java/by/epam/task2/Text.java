package by.epam.task2;

import java.text.BreakIterator;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Text implements Component {
    private List<Sentence> sentences = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(Text.class);

    public Text() {
    }

    public Text(String content) {
        sentencesLikeObject(sentencesLikeAString(content));
        LOGGER.info("was created: " + this.print());
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }


    private List<String> sentencesLikeAString(String wholeText) {
        if (wholeText.isBlank())
            LOGGER.warn("Empty string received!");

        List<String> sentences = new ArrayList<>();

        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(wholeText);
        int lastIndex = iterator.first();

        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = iterator.next();

            if (lastIndex != BreakIterator.DONE) {
                String sentence = wholeText.substring(firstIndex, lastIndex);
                sentences.add(sentence);
            }
        }

        return sentences;
    }

    private void sentencesLikeObject(List<String> stringSentences) {
        for (String s : stringSentences) {
            this.sentences.add(new Sentence(Sentence.stringToComponents(s)));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * 6.	Напечатать слова текста в алфавитном порядке по первой
     * букве. Слова, начинающиеся с новой буквы, печатать с красной строки.
     */
    public String taskNumber6() {
        String result = "\t";
        List<Component> words = new ArrayList<>();

        // extract words:
        for (Sentence sentence : sentences)
            words.addAll(sentence.getWords());

        for (int i = 0; i < words.size(); i++) {
            words.set(i, new Word(words.get(i).print().toLowerCase()));
        }


        words.sort(Comparator.comparing(Component::print));

        char firstLetterCurrentWord;
        char firstLetterNextWord;

        for (int i = 0; i < words.size() - 1; i++) {
            firstLetterCurrentWord = words.get(i).print().charAt(0);
            firstLetterNextWord = words.get(i + 1).print().charAt(0);

            result += words.get(i).print() + "\n";
            if (firstLetterNextWord != firstLetterCurrentWord)
                result += "\t";
        }


        return result;
    }

    @Override
    public String toString() {
        return this.print();
    }

    @Override
    public String print() {
        String result = "";
        for (Sentence sentence : sentences)
            result += sentence.print() + " ";
        result = result.replaceAll("\\s+$", "");
        return result;
    }
}
