package model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "sentence")
public class Sentence {
    @XmlElement(name = "word")
    private final List<String> words;


    public Sentence() {
        this.words = new ArrayList<>();
    }

    public Sentence(List<String> words) {
        words.sort(String::compareToIgnoreCase);
        this.words = words;
    }

    public void addWord(String word) {
        this.words.add(word);
    }

    public int wordsSize() {
        return this.words.size();
    }
}
