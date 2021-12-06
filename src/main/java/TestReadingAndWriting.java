import model.Text;
import readingservice.ConsoleReader;
import readingservice.FileReader;
import readingservice.Reader;
import writingservice.Writer;
import writingservice.csv.CSVConsoleWriter;
import writingservice.csv.CSVFileWriter;
import writingservice.xml.XMLConsoleWriter;
import writingservice.xml.XMLFileWriter;

import java.io.IOException;

public class TestReadingAndWriting {
    public static void main(String[] args) {
        Reader reader = new FileReader("./src/main/resources/test-input.txt");
        Text read = null;
        try {
            read = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Writer writer = new CSVFileWriter("src/main/resources/test.csv");
        try {
            writer.write(read);
        } catch (Exception e) {
            e.printStackTrace();
        }

        writer = new XMLFileWriter("src/main/resources/test.xml");
        try {
            writer.write(read);
        } catch (Exception e) {
            e.printStackTrace();
        }

        writer = new CSVConsoleWriter();
        try {
            writer.write(read);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

        writer = new XMLConsoleWriter();
        try {
            writer.write(read);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
