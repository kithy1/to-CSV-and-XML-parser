package readingservice;

import model.Sentence;
import model.Text;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import writingservice.testutils.TextFromFileCreator;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    private final Reader reader = new FileReader("./src/main/resources/test-input.txt");

    @Test
    void read() throws IOException {
        Text read = reader.read();
        List<Sentence> sentences = read.getSentences();
        Sentence sentence = sentences.get(0);
        List<String> words = sentence.getWords();
        Text text = TextFromFileCreator.prepareText();
        List<Sentence> sentences1 = text.getSentences();
        Sentence sentence1 = sentences1.get(0);
        List<String> words1 = sentence1.getWords();
        Assertions.assertLinesMatch(words1, words);
    }
}