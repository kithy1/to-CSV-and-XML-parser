package readingservice;

import model.Sentence;
import model.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConsoleReader implements Reader {

    @Override
    public Text read() {
        Scanner in = new Scanner(System.in);
        System.out.println("write a text, press enter, q and enter to finish: ");

        List<String> lines = new ArrayList<>();
        while (in.hasNext()) {
            String next = in.nextLine();
            if (next.equals("q")) {
                break;
            }
            if (!next.isBlank() && !next.isEmpty()) {
                lines.add(next);
            }
        }
        return createText(lines);
    }

    public Text createText(List<String> lines) {
        List<Sentence> sentences = createSentencesList(splitByDot(concatLines(lines)));
        return new Text(sentences);
    }

    private String concatLines(List<String> lines) {
        return lines.stream().collect(Collectors.joining(" "));
    }

    private List<String> splitByDot(String input) {
        return List.of(input.split("\\."));
    }

    private List<Sentence> createSentencesList(List<String> strings) {
        return strings.parallelStream()
                .filter(this::isNotSpecialSign)
                .map(s -> Arrays.stream(s.split(" "))
                        .map(this::sanitizeSpecialSigns)
                        .map(String::strip)
                        .filter(s2 -> !s2.isBlank() && !s2.isEmpty()))
                .map(s2 -> s2.collect(Collectors.toList()))
                .filter(strings1 -> strings1.size() > 0)
                .map(Sentence::new)
                .collect(Collectors.toList());
    }

    private boolean isNotSpecialSign(String input) {
        Pattern pattern = Pattern.compile("\\W");
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }

    private String sanitizeSpecialSigns(String input) {
        return input.replaceAll("\\W", "");
    }
}
