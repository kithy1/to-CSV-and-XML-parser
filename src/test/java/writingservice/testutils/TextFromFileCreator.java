package writingservice.testutils;

import model.Sentence;
import model.Text;

import java.util.ArrayList;
import java.util.List;

public class TextFromFileCreator {

    public static Text prepareText() {
        Sentence sentence = new Sentence();
        sentence.addWord("a");
        sentence.addWord("had");
        sentence.addWord("lamb");
        sentence.addWord("little");
        sentence.addWord("Mary");

        Sentence sentence1 = new Sentence();
        sentence1.addWord("Aesop");
        sentence1.addWord("and");
        sentence1.addWord("called");
        sentence1.addWord("came");
        sentence1.addWord("for");
        sentence1.addWord("Peter");
        sentence1.addWord("the");
        sentence1.addWord("wolf");

        Sentence sentence2 = new Sentence();
        sentence2.addWord("Cinderella");
        sentence2.addWord("likes");
        sentence2.addWord("shoes");


        List<Sentence> sentences = new ArrayList<>();
        sentences.add(sentence);
        sentences.add(sentence1);
        sentences.add(sentence2);
        return new Text(sentences);
    }
}
