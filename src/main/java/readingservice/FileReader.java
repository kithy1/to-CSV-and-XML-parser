package readingservice;

import model.Text;
import utils.TextCreator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader implements Reader {
    private String inputPath;

    public FileReader(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public Text read() throws IOException {
        List<String> lines = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(inputPath); Scanner sc = new Scanner(inputStream, "UTF-8")) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lines.add(line);
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        }
        return TextCreator.createText(lines);
    }
}
