import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordFrequencyTest {
    WordFrequency counter = new WordFrequency();

    @Test
    public void countsOccurrencesOfOne() {
        assertEquals(1, counter.countsOneWord("hi", "hi"));
    }

    @Test
    public void countsOccurrencesOfTwo() {
        assertEquals(2, counter.countsOneWord("hi", "hi hi"));
    }

    @Test
    public void countsOccurrencesOfTwoDifferentWords() {
        assertEquals(1, counter.countsOneWord("hi", "hi there"));
    }

    @Test
    public void countsOccurrencesOfWordInSentence() {
        assertEquals(2, counter.countsOneWord("hi", "hi there hi"));
    }

    @Test
    public void countsOccurrencesOfDifferentWords() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("hi",2);
        expected.put("there", 1);
        assertEquals(expected, counter.histogram("hi there hi"));
    }

    @Test
    public void sorts() {
        HashMap<String, Integer> sortedHistogram = new HashMap<>();
        sortedHistogram.put("there", 1);
        sortedHistogram.put("hi", 2);
        HashMap<String, Integer> result = new HashMap<>();
        result.put("hi", 2);
        result.put("there", 1);
        assertEquals(sortedHistogram, counter.sort(result));
    }

    @Test
    public void printsOrderedHistogram() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("hi", 2);
        result.put("there", 1);
        List hashToString = new ArrayList<>();
        hashToString.add("hi=2");
        hashToString.add("there=1");
        assertEquals(hashToString,counter.print(result));
    }



}
