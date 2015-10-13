import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFrequency {

    public int countsOneWord(String word, String sentence) {
        Pattern find = Pattern.compile(word);
        Matcher matcher = find.matcher(sentence);
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public HashMap<String, Integer> histogram(String sentence) {
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        String[] individualWords = sentence.split(" ");
        for (String individualWord : individualWords) {
            wordFrequency.put(individualWord, countsOneWord(individualWord, sentence));
        }
        return wordFrequency;
    }


    public HashMap<String, Integer> sort(HashMap<String, Integer> wordFrequency) {
        List list = new LinkedList(wordFrequency.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        HashMap sortedResult = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry)it.next();
            sortedResult.put(entry.getKey(),entry.getValue());
        }
        return sortedResult;
    }



    public List print(HashMap<String, Integer> ordered) {
        List hashToString = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : ordered.entrySet()) {
            hashToString.add(entry.getKey() + "=" + entry.getValue());
        }
            return hashToString;
    }

}


