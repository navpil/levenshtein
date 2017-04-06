package ua.lviv.navpil.levenstein;

import java.util.Collection;

public class SimilarWordFinder {

    private final Levenshtein levenshtein;

    public SimilarWordFinder(Levenshtein levenshtein) {
        this.levenshtein = levenshtein;
    }

    public String getMostSimilarWord(String word, Collection<String> similarWords) {
        int minLevenstein = Integer.MAX_VALUE;
        String mostSimilarWord = null;
        for ( String similarWord : similarWords ) {
            int levensteinDistance = levenshtein.calculateDistance( similarWord, word );
            if ( levensteinDistance < minLevenstein ) {
                minLevenstein = levensteinDistance;
                mostSimilarWord = similarWord;
            }
        }
        return mostSimilarWord;
    }

}
