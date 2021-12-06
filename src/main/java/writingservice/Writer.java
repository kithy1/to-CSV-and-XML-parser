package writingservice;

import model.Text;

//import javax.xml.bind.JAXBException;

public interface Writer {

    void write(Text text) throws Exception;
}
