package writingservice.xml;

import model.Text;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import writingservice.Writer;
import writingservice.testutils.TextCreator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class XMLFileWriterTest {
    private Writer writer;

    private File file;

    @BeforeEach
    public void init() throws IOException {
        this.file = File.createTempFile("FileWritingTest", "tmp");
        writer = new XMLFileWriter(this.file.getAbsolutePath());
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
        String out = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<text>\n" +
                "    <sentence>\n" +
                "        <word>Ala</word>\n" +
                "        <word>ma</word>\n" +
                "        <word>kota</word>\n" +
                "    </sentence>\n" +
                "</text>\n";
        Assertions.assertEquals(out, new String(Files.readAllBytes(file.toPath())));
    }
}