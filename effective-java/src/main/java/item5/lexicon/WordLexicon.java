package item5.lexicon;

import item5.lexicon.domain.Word;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class WordLexicon implements Lexicon<Word> {

    private final Map<String, Word> words =
            new TreeMap<>(String::compareTo);

    @Override
    public void addWord(String spelling, Word word) {
        words.putIfAbsent(spelling, word);
    }

    @Override
    public Optional<Word> searchIgnoreCase(String spelling) {
        return Optional.ofNullable(
                words.getOrDefault(spelling, null)
        );
    }

    @Override
    public List<Word> findWordsStartingWith(String prefix) {
        return words.entrySet()
                .stream()
                .filter(entry ->
                        entry.getKey().startsWith(prefix))
                .map(Map.Entry::getValue)
                .toList();
    }
}
