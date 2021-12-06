package writingservice.testutils;

import model.Sentence;
import model.Text;

import java.util.ArrayList;
import java.util.List;

public class TextCreator {

    public static Text prepareText() {
        Sentence sentence = new Sentence();
        sentence.addWord("Ala");
        sentence.addWord("ma");
        sentence.addWord("kota");
        List<Sentence> sentences = new ArrayList<>();
        sentences.add(sentence);
        return new Text(sentences);
    }
}
