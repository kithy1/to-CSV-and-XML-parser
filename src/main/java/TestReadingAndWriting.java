import model.Text;
import readingservice.ConsoleReader;
import writingservice.Writer;
import writingservice.csv.CSVConsoleWriter;
import writingservice.csv.CSVFileWriter;
import writingservice.xml.XMLConsoleWriter;
import writingservice.xml.XMLFileWriter;

public class TestReadingAndWriting {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        Text read = reader.read();

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
