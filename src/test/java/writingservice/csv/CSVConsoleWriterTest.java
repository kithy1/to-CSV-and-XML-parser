package writingservice.csv;

import model.Text;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import writingservice.Writer;
import writingservice.testutils.TextCreator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVConsoleWriterTest {
    private final Writer consoleWriter = new CSVConsoleWriter();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void write() throws Exception {
        Text text = TextCreator.prepareText();
        consoleWriter.write(text);

        String newLine = System.getProperty("line.separator");
        String out = ", Word 1, Word 2, Word 3" + newLine +
                "Sentence 1, Ala, ma, kota" + newLine;
        assertEquals(out, outContent.toString());
    }
}