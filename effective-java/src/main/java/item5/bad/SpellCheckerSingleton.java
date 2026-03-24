package item5.bad;

import item5.lexicon.Lexicon;
import item5.lexicon.WordLexicon;
import item5.lexicon.domain.Word;

import java.util.List;

public class SpellCheckerSingleton {

    private static final Lexicon<Word> dictionary = new WordLexicon();

    private static final SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    private SpellCheckerSingleton() {

    }

    public static SpellCheckerSingleton getInstance() {
        return INSTANCE;
    }

    public boolean isValid(String spelling) {
        return dictionary.searchIgnoreCase(spelling).isPresent();
    }

    public List<Word> suggestions(String spelling) {
        return dictionary.findWordsStartingWith(spelling);
    }
}
