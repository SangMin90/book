package item5.lexicon;

import java.util.List;
import java.util.Optional;

public interface Lexicon<T> {

    void addWord(String spelling, T word);
    Optional<T> searchIgnoreCase(String spelling);
    List<T> findWordsStartingWith(String spelling);
}
