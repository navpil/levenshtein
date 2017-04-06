package ua.lviv.navpil.levenstein;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SimilarWordFinderTest {
    @Test
    public void getMostSimilarWord() throws Exception {
        LevenshteinOneDimArrayBased levenshtein = new LevenshteinOneDimArrayBased();
        SimilarWordFinder finder = new SimilarWordFinder(levenshtein);

        String mostSimilarWord = finder.getMostSimilarWord("hibernate", Arrays.asList("hiber", "jpa", "bernat", "jibernate", "hibernation"));
        assertEquals("jibernate", mostSimilarWord);
    }

}