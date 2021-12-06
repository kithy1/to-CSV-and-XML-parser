package writingservice.csv;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import model.Text;
import utils.CsvDataCreator;
import writingservice.Writer;

import java.io.FileWriter;
import java.util.List;

public class CSVFileWriter implements Writer {
    private String outputPath;

    public CSVFileWriter(String outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public void write(Text text) throws Exception {
        List<String[]> csvData = CsvDataCreator.createCsvData(text);
        try (ICSVWriter writer = new CSVWriterBuilder(
                new FileWriter(outputPath))
                .withSeparator(',')
                .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .build()) {
            writer.writeAll(csvData);
        }
    }
}
