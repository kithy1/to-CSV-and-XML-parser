package writingservice.csv;

import model.Text;
import utils.CsvDataCreator;
import writingservice.Writer;

import java.util.List;

public class CSVConsoleWriter implements Writer {

    @Override
    public void write(Text text) {
        List<String[]> csvData = CsvDataCreator.createCsvData(text);
        for (String[] strings : csvData) {
            System.out.println(String.join(",", strings));

        }
    }
}
