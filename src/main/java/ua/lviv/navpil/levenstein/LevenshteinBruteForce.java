package ua.lviv.navpil.levenstein;

public class LevenshteinBruteForce implements Levenshtein {

    @Override
    public int calculateDistance(String s, String t) {
        return levensteinDistance( s, s.length(), t, t.length() );
    }

    private static int levensteinDistance(String s, int sLength, String t, int tLength) {
        int cost;

        // base case: empty strings
        if ( sLength == 0 ) {
            return tLength;
        }
        if ( tLength == 0 ) {
            return sLength;
        }

        //test if last characters of the strings match
        if ( s.charAt( sLength - 1 ) == t.charAt( tLength - 1 ) ) {
            cost = 0;
        }
        else {
            cost = 1;
        }

        //return minimum of delete char from s, delete char from t, and delete char from both
        return Math.min(
                Math.min(
                        levensteinDistance( s, sLength - 1, t, tLength ) + 1,
                        levensteinDistance( s, sLength, t, tLength - 1 ) + 1
                ),
                levensteinDistance( s, sLength - 1, t, tLength - 1 ) + cost
        );
    }
}
