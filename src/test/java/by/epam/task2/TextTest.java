package by.epam.task2;

import by.epam.additional.MethodsForFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TextTest {
    private static Text text;

    @BeforeAll
    public static void init() {
        List<Sentence> sentences = new ArrayList<>();
        // Take the multiple-choice quiz following each text, and you'll get the results immediately.
        sentences.add(new Sentence(Arrays.asList(new Word("Take"), new Word("the"),
                new Word("multiple-choice"), new Word("quiz"), new Word("following"),
                new Word("each"), new Word("text"), Punctuation.COMMA, new Word("and"),
                new Word("you'll"), new Word("get"), new Word("the"), new Word("results"),
                new Word("immediately"), Punctuation.DOT)));

        //You will feel both challenged and accomplished!
        sentences.add(new Sentence(Arrays.asList(new Word("You"), new Word("will"),
                new Word("feel"), new Word("both"), new Word("challenged"),
                new Word("and"), new Word("accomplished"), Punctuation.EXCLAMATION)));

        //It's enjoyable, fun and free.
        sentences.add(new Sentence(Arrays.asList(new Word("It's"), new Word("enjoyable"),
                Punctuation.COMMA, new Word("fun"), new Word("and"), new Word("free"), Punctuation.DOT)));

        //Good luck!
        sentences.add(new Sentence(Arrays.asList(new Word("Good"), new Word("luck"),
                Punctuation.EXCLAMATION)));

        text = new Text(sentences);
    }


    @ParameterizedTest
    @MethodSource("sumParametersFile")
    public void testParseFile(String path, String expected) {

        String answer = expected;


        String predicted = MethodsForFile.parseFile(path);

        Assertions.assertEquals(predicted, answer);
    }

    public static Stream sumParametersFile() {
        String s1 = "Take the multiple-choice quiz following each text, and you'll get the results immediately." +
                " You will feel both challenged and accomplished! It's enjoyable, fun and free. Good luck!";

        String s2 = "These are short, famous texts in English from classic sources like the Bible or Shakespeare. \r\n" +
                "Some texts have word definitions and explanations to help you. \r\n" +
                "Some of these texts are written in an old style of English.";


        return Stream.of(
                Arguments.of("src\\main\\resources\\test-text1.txt", s1),
                Arguments.of("src\\main\\resources\\test-text2.txt", s2)
        );
    }

    @ParameterizedTest
    @MethodSource("sumParametersGetWord")
    public void testGetWords(int index, List<Word> expected) {
        List<Word> answer = expected;

        List<Component> predicted = text.getSentences().get(index).getWords();

        Assertions.assertEquals(predicted, answer);
    }

    public static Stream sumParametersGetWord() {
        List<Word> words0 = new ArrayList<>();
        words0.addAll(Arrays.asList(new Word("Take"), new Word("the"),
                new Word("multiple-choice"), new Word("quiz"), new Word("following"),
                new Word("each"), new Word("text"), new Word("and"),
                new Word("you'll"), new Word("get"), new Word("the"), new Word("results"),
                new Word("immediately")));

        List<Word> words1 = new ArrayList<>();
        words1.addAll(Arrays.asList(new Word("You"), new Word("will"),
                new Word("feel"), new Word("both"), new Word("challenged"),
                new Word("and"), new Word("accomplished")));

        List<Word> words2 = new ArrayList<>();
        words2.addAll(Arrays.asList(new Word("It's"), new Word("enjoyable"),
                new Word("fun"), new Word("and"), new Word("free")));

        List<Word> words3 = new ArrayList<>();
        words3.addAll(Arrays.asList(new Word("Good"), new Word("luck")));

        return Stream.of(
                Arguments.of(0, words0),
                Arguments.of(1, words1),
                Arguments.of(2, words2),
                Arguments.of(3, words3)
        );
    }

    @ParameterizedTest
    @MethodSource("sumParametersGetPunctuation")
    public void testGetPunctuation(int index, List<Punctuation> expected) {
        List<Punctuation> answer = expected;

        List<Component> predicted = text.getSentences().get(index).getPunctuation();

        Assertions.assertEquals(predicted, answer);
    }

    public static Stream sumParametersGetPunctuation() {
        List<Punctuation> punctuation0 = new ArrayList<>();
        punctuation0.addAll(Arrays.asList(Punctuation.COMMA, Punctuation.DOT));

        List<Punctuation> punctuation1 = new ArrayList<>();
        punctuation1.addAll(Arrays.asList(Punctuation.EXCLAMATION));

        List<Punctuation> punctuation2 = new ArrayList<>();
        punctuation2.addAll(Arrays.asList(Punctuation.COMMA, Punctuation.DOT));

        List<Punctuation> punctuation3 = new ArrayList<>();
        punctuation3.addAll(Arrays.asList(Punctuation.EXCLAMATION));

        return Stream.of(
                Arguments.of(0, punctuation0),
                Arguments.of(1, punctuation1),
                Arguments.of(2, punctuation2),
                Arguments.of(3, punctuation3)
        );
    }

    @Test
    public void testTextPrint() {
        String answer = "Take the multiple-choice quiz following each text, and you'll get the results immediately. " +
                "You will feel both challenged and accomplished! It's enjoyable, fun and free. Good luck!";

        String predicted = text.print();

        Assertions.assertEquals(predicted, answer);

    }

    @Test
    public void testTaskNumber6() {
        String answer = "\taccomplished\n" +
                "and\n" +
                "and\n" +
                "and\n" +
                "\tboth\n" +
                "\tchallenged\n" +
                "\teach\n" +
                "enjoyable\n" +
                "\tfeel\n" +
                "following\n" +
                "free\n" +
                "fun\n" +
                "\tget\n" +
                "good\n" +
                "\timmediately\n" +
                "it's\n" +
                "\tluck\n" +
                "\tmultiple-choice\n" +
                "\tquiz\n" +
                "\tresults\n" +
                "\ttake\n" +
                "text\n" +
                "the\n" +
                "the\n" +
                "\twill\n" +
                "\tyou\n";

        String predicted = text.taskNumber6();

        Assertions.assertEquals(predicted, answer);

    }
}


