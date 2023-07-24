import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvDataFrameProvider implements DataFrameProvider {
    private final String filename;
    private final boolean headerExists;
    private final String separator;

    @Override
    public DataFrame getDataFrame() {
        try {
            InputStreamReader reader = new FileReader(filename);
            List<String> header = readHeader(reader);
            List<List<String>> data = readData(reader);
            reader.close();
            return new DataFrame(header, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private List<List<String>> readData(InputStreamReader reader) {
        Scanner scanner = new Scanner(reader);
        List<List<String>> data = new ArrayList<>();
        while (scanner.hasNext()) {
            data.add(Arrays.stream(scanner.nextLine().split(separator)).toList());
        }
        return data;
    }

    private List<String> readHeader(InputStreamReader reader) {
        if (!headerExists){
            return new ArrayList<>();
        }
        Scanner scanner = new Scanner(reader);
        String headerLine = scanner.nextLine();
        return Arrays.stream(headerLine.split(separator)).toList();
    }

    public CsvDataFrameProvider (String filename, boolean headerExists, String separator){
        this.filename = filename;
        this.headerExists = headerExists;
        this.separator = separator;
    }

    public CsvDataFrameProvider (String filename, String separator){
        this.filename = filename;
        this.headerExists = true;
        this.separator = separator;
    }

    public CsvDataFrameProvider (String filename){
        this.filename = filename;
        this.headerExists = true;
        this.separator = ",";
    }
}
