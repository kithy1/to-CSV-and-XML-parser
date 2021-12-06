package utils;

import model.Sentence;
import model.Text;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextCreator {
    public static Text createText(List<String> lines) {
        List<Sentence> sentences = createSentencesList(splitByDot(concatLines(lines)));
        return new Text(sentences);
    }

    private static String concatLines(List<String> lines) {
        return lines.stream().collect(Collectors.joining(" "));
    }

    private static List<String> splitByDot(String input) {
        return List.of(input.split("\\."));
    }

    private static List<Sentence> createSentencesList(List<String> strings) {
        return strings.parallelStream()
                .filter(TextCreator::isNotSpecialSign)
                .map(s -> Arrays.stream(s.split(" "))
                        .map(TextCreator::sanitizeSpecialSigns)
                        .map(String::strip)
                        .filter(s2 -> !s2.isBlank() && !s2.isEmpty()))
                .map(s2 -> s2.collect(Collectors.toList()))
                .filter(strings1 -> strings1.size() > 0)
                .map(Sentence::new)
                .collect(Collectors.toList());
    }

    private static boolean isNotSpecialSign(String input) {
        Pattern pattern = Pattern.compile("\\W");
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }

    private static String sanitizeSpecialSigns(String input) {
        return input.replaceAll("\\W", "");
    }
}
