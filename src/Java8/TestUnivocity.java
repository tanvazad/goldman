package Java8;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class TestUnivocity {

    public void parseCSV(String fileName){
        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.setLineSeparatorDetectionEnabled(true);
        RowListProcessor rowListProcessor = new RowListProcessor();
        parserSettings.setRowProcessor(rowListProcessor);
        parserSettings.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(parserSettings);
        parser.parse(new File(fileName));

        String[] headers = rowListProcessor.getHeaders();
        List<String[]> row =rowListProcessor.getRows();
        for(int i = 0; i< row.size(); i++){
            System.out.println(Arrays.asList(row.get(i)));
        }
        for(String s:headers){
            System.out.print(s+" ");
        }
    }

    public static void main(String[] args){
    TestUnivocity test = new TestUnivocity();
    test.parseCSV("C:\\testCSV1.csv");
    }
}
