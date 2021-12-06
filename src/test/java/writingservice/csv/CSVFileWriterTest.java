package writingservice.csv;

import model.Text;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import writingservice.Writer;
import writingservice.testutils.TextCreator;
import writingservice.testutils.TextFromFileCreator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class CSVFileWriterTest {
    private Writer writer;

    private File file;

    @BeforeEach
    public void init() throws IOException {
        this.file = File.createTempFile("FileWritingTest", "tmp");
        writer = new CSVFileWriter(this.file.getAbsolutePath());
        file.deleteOnExit();
    }

    @AfterEach
    public void clean() {
        this.file.delete();
    }

    @Test
    void write() throws Exception {
        Text text = TextCreator.prepareText();
        writer.write(text);
        String out = ", Word 1, Word 2, Word 3\n"+
                "Sentence 1, Ala, ma, kota\n";
        Assertions.assertEquals(out, new String(Files.readAllBytes(file.toPath())));
    }
}