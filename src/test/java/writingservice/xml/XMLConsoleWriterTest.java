package writingservice.xml;

import model.Text;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import writingservice.Writer;
import writingservice.testutils.TextCreator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XMLConsoleWriterTest {
    private final Writer writer = new XMLConsoleWriter();

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
        writer.write(text);

        String out = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<text>\n" +
                "    <sentence>\n" +
                "        <word>Ala</word>\n" +
                "        <word>ma</word>\n" +
                "        <word>kota</word>\n" +
                "    </sentence>\n" +
                "</text>\n" ;
        assertEquals(out, outContent.toString());
    }
}