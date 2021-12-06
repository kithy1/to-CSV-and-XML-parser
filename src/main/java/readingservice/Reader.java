package readingservice;

import model.Text;

import java.io.IOException;

public interface Reader {
     Text read() throws IOException;
}
