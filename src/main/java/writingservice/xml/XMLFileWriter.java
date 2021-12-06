package writingservice.xml;


import model.Text;
import writingservice.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XMLFileWriter implements Writer {
    private String outputPath;

    public XMLFileWriter(String outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public void write(Text text) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Text.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(text, new File(outputPath));
    }
}
