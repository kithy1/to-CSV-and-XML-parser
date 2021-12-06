package model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Getter
@XmlRootElement(name = "text")
@NoArgsConstructor
public class Text {
    @XmlElement(name = "sentence")
    private List<Sentence> sentences = new ArrayList<>();

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
