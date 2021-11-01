package by.epam.task2;

import java.util.Objects;

public class Word implements Component {
    String value;

    public Word() {
    }

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Word))
            return false;
        Word word = (Word) o;
        return getValue().equals(word.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String print() {
        return this.value;
    }
}
