package ua.lviv.navpil.levenstein;

public class LevenshteinArrayBased implements Levenshtein {

    @Override
    public int calculateDistance(String s, String t) {
        int sLength = s.length() + 1;
        int tLength = t.length() + 1;

        int [][] distances = new int[tLength][];
        for (int i = 0; i < tLength; i++) {
            distances[i] = new int[sLength];
        }

        for (int i = 0; i < tLength; i++) {
            distances[i][0] = i;
        }
        for (int i = 0; i < sLength; i++) {
            distances[0][i] = i;
        }

        for (int i = 1; i < tLength; i++) {
            for (int j = 1; j < sLength; j++) {
                int cost = s.charAt( j - 1 ) == t.charAt( i - 1 ) ? 0 : 1;
                distances[i][j] = Math.min(
                        Math.min(
                                distances[i - 1][j] + 1,
                                distances[i][j - 1] + 1
                        ),
                        distances[i-1][j-1] + cost
                );
            }
        }

        return distances[tLength - 1][sLength - 1];
    }
}
