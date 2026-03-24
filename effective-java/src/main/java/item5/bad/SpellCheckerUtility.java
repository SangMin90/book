package item5.bad;

import item5.lexicon.Lexicon;
import item5.lexicon.WordLexicon;
import item5.lexicon.domain.Word;

import java.util.List;

public class SpellCheckerUtility {

    private static final Lexicon<Word> dictionary = new WordLexicon();

    private SpellCheckerUtility() {

    }

    public static boolean isValid(String spelling) {
        return dictionary.searchIgnoreCase(spelling).isPresent();
    }

    public List<Word> suggestions(String spelling) {
        return dictionary.findWordsStartingWith(spelling);
    }
}
