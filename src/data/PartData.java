package data;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartData {

    static boolean isDataLoaded;

    private static final String DATA_FILE = "src/resources/part_data.csv";

    public static ArrayList<Map> allParts;

    //Copied from techjobs-console-java, modified
    public static void loadData() {

        // Only load data once

        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Reader in = new FileReader(DATA_FILE);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            List<CSVRecord> records = parser.getRecords();
            int numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            allParts = new ArrayList<>();

            // Put the records into a more friendly format
            for (CSVRecord record : records) {
                HashMap<String, String> newPart = new HashMap<>();

                for (String headerLabel : headers) {
                    newPart.put(headerLabel, record.get(headerLabel));
                }

                allParts.add(newPart);
            }

            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load part data");
            e.printStackTrace();
        }
    }

}
