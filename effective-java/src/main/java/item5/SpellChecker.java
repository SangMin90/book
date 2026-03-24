package item5;

import item5.lexicon.Lexicon;

import java.util.List;

public class SpellChecker<T> {

    private final Lexicon<T> dictionary;


    public SpellChecker(Lexicon<T> dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(String spelling) {
        return dictionary.searchIgnoreCase(spelling).isPresent();
    }

    public List<T> suggestions(String spelling) {
        return dictionary.findWordsStartingWith(spelling);
    }
}
