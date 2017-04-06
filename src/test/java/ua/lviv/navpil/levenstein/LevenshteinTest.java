package ua.lviv.navpil.levenstein;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LevenshteinTest {

    private LevenshteinBruteForce bruteForce;
    private LevenshteinArrayBased arrayBased;
    private LevenshteinOneDimArrayBased oneDimBased;

    @Before
    public void setup() {
        bruteForce = new LevenshteinBruteForce();
        arrayBased = new LevenshteinArrayBased();
        oneDimBased = new LevenshteinOneDimArrayBased();
    }

    @Test
    public void levenshteinDistance() throws Exception {
        String [] strings = {"Any", "whatever", "sjehehe", "sekskse", "anana", "whauvaer"};

        for (String s : strings) {
            for (String t : strings) {
                compare(s, t);
            }
        }
    }

    @Test
    public void compareTwoSimilarStrings() {
        compare("hell", "hello");
    }

    @Test
    public void compareEmptyStrings() {
        compare("", "1");
        compare("1", "");
        compare("", "");
    }

    @Test
    public void compareComplexity() {
        long arrayBasedTime = calculateTime(() -> arrayBased.calculateDistance("asdfa453erq;w", "flkajs213ds5f"));
        long bruteForceTime = calculateTime(() -> bruteForce.calculateDistance("asdfa453erq;w", "flkajs213ds5f"));
        System.out.println("Difference was " + arrayBasedTime + " to " + bruteForceTime + " what is " + (bruteForceTime / arrayBasedTime) + " times less");
        Assert.assertTrue(arrayBasedTime < bruteForceTime);
    }

    private long calculateTime(Runnable runnable) {
        long l = System.nanoTime();
        runnable.run();
        return System.nanoTime() - l;
    }

    private void compare(String s, String t) {
        int bruteForceLevenstein = bruteForce.calculateDistance(s, t);
        System.out.println("Comparing " + s + " with " + t + ", bruteForce levenshtein: " + bruteForceLevenstein);
        Assert.assertEquals("ArrayBased calculated wrong values", +bruteForceLevenstein, arrayBased.calculateDistance(s, t));
        Assert.assertEquals("DimBased calculated wrong values", +bruteForceLevenstein, oneDimBased.calculateDistance(s, t));
    }

}