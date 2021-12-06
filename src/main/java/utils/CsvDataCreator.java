package utils;

import model.Sentence;
import model.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CsvDataCreator {

    public static List<String[]> createCsvData(Text text) {
        List<Sentence> sentences = text.getSentences();

        Sentence sentence2 = sentences.stream().min((o1, o2) -> o2.wordsSize() - o1.wordsSize()).orElseThrow(() -> new IllegalStateException("List of Sentences is empty"));

        String[] array2 = Stream.iterate(1, integer -> integer + 1).map(integer -> " Word " + integer).limit(sentence2.wordsSize()).toArray(String[]::new);
        String[] result = Arrays.copyOf(new String[]{""}, 1 + array2.length);
        System.arraycopy(array2, 0, result, 1, array2.length);

        List<String[]> list = new ArrayList<>();
        list.add(result);
        for (int i = 0; i < sentences.size() ; i++) {
            Sentence sentence3 = sentences.get(i);
            String[] strings = new String[sentence3.wordsSize()+1];
            List<String> words = sentence3.getWords();
            strings[0] = "Sentence " + (i+1);
            for (int j = 0; j < words.size(); j++) {
                strings[j+1] = " " +words.get(j);
            }
            list.add(strings);
        }
        return list;
    }
}
