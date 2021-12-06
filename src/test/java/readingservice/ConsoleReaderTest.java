package readingservice;

import model.Text;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleReaderTest {
    private final Reader reader = new ConsoleReader();

    private final InputStream sysInBackup = System.in;
    private final String input = "“ Mary had a little lamb .\n" +
            " Peter called for the wolf , and Aesop came .\n" +
            " Cinderella likes shoes..”\n" +
            "q\r";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());

    @BeforeEach
    public void setUpStreams() {
        System.setIn(in);
    }
    @AfterEach
    public void restoreStreams() {
        System.setIn(sysInBackup);
    }
    @Test
    void read() throws IOException {
        Text read = reader.read();
        Assertions.assertEquals(3, read.getSentences().size());
    }
}