package item5.lexicon.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {

    private final String pronunciation;
    private final String description;
    private final List<String> synonym = new ArrayList<>();

    public Word(String pronunciation, String description, String... synonyms) {
        this.pronunciation = pronunciation;
        this.description = description;
        synonym.addAll(List.of(synonyms));
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Word word)) return false;
        return Objects.equals(pronunciation, word.pronunciation) && Objects.equals(description, word.description) && Objects.equals(synonym, word.synonym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pronunciation, description, synonym);
    }
}
