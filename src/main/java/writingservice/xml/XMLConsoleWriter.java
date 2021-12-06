package writingservice.xml;

import model.Text;
import writingservice.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class XMLConsoleWriter implements Writer {

    @Override
    public void write(Text text) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Text.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(text, System.out);
    }
}
