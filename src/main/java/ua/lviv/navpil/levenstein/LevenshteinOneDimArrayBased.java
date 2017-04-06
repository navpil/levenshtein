package ua.lviv.navpil.levenstein;

public class LevenshteinOneDimArrayBased implements Levenshtein {

    @Override
    public int calculateDistance(String s, String t) {
        int sLength = s.length() + 1;
        int tLength = t.length() + 1;

        int[] distances = new int[tLength];

        for (int i = 0; i < tLength; i++) {
            distances[i] = i;
        }

        for (int i = 1; i < sLength; i++) {
            int leftUpCorner = distances[0];
            distances[0] = i;
            for (int j = 1; j < tLength; j++) {
                int tempLeftUpCorner = distances[j];
                int cost = s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1;
                distances[j] = Math.min(
                        Math.min(
                                distances[j] + 1,
                                distances[j - 1] + 1
                        ),
                        leftUpCorner + cost
                );
                leftUpCorner = tempLeftUpCorner;
            }
        }

        return distances[tLength - 1];
    }
}
