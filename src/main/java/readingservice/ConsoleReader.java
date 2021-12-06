package readingservice;

import model.Text;
import utils.TextCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        return TextCreator.createText(lines);
    }
}
