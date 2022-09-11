package data;
import models.items.bulletparts.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class PartData {

    static boolean isDataLoaded;

    private static final String DATA_FILE = "src/resources/part_data.csv";

    public static ArrayList<Map<String, String>> allParts;

    public static final HashMap<String, Casing> allCasings = new HashMap<>();
    public static final HashMap<String, Dust> allDust = new HashMap<>();
    public static final HashMap<String, Powder> allPowder = new HashMap<>();
    public static final HashMap<String, Primer> allPrimer = new HashMap<>();
    public static final HashMap<String, Projectile> allProjectile = new HashMap<>();
    public static final HashMap<String, Shape> allShape = new HashMap<>();

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

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void loadPartData() {
        loadData();
        for (Map<String, String> part : allParts) {
            HashMap<String, Double> stats = new HashMap<>();
            stats.put("Damage", 0.0);
            stats.put("Piercing", 0.0);
            stats.put("Speed", 0.0);
            stats.put("Power", 0.0);
            stats.put("Value", 0.0);


            for (String strNum : part.values()) {
                if(isNumeric(strNum)) {
                    double num = Double.parseDouble(strNum);
                    for (Map.Entry<String, Double> stat : stats.entrySet()) {
                        if(part.containsKey(stat.getKey())) {
                            stats.replace(stat.getKey(), num);
                        }
                    }
                }
            }

            if (part.get("type").contains("Casing")) {
                allCasings.put(part.get("Name"), new Casing(part.get("Name"), stats.get("Damage"), stats.get("Piercing"),
                        stats.get("Speed"), stats.get("Power"), stats.get("Value")));
            }
            if (part.get("type").contains("Dust") || part.get("type").contains("Oil")) {
                allDust.put(part.get("Name"), new Dust(part.get("Name"), part.get("Type"), stats.get("Damage"), stats.get("Piercing"),
                        stats.get("Speed"), stats.get("Power"), stats.get("Value")));
            }
            if (part.get("type").contains("Powder")) {
                allPowder.put(part.get("Name"), new Powder(part.get("Name"), stats.get("Damage"), stats.get("Piercing"),
                        stats.get("Speed"), stats.get("Power"), stats.get("Value")));
            }
            if (part.get("type").contains("Primer")) {
                allPrimer.put(part.get("Name"), new Primer(part.get("Name"), stats.get("Damage"), stats.get("Piercing"),
                        stats.get("Speed"), stats.get("Power"), stats.get("Value")));
            }
            if (part.get("type").contains("Shape")) {
                allShape.put(part.get("Name"), new Shape(part.get("Name"), stats.get("Damage"), stats.get("Piercing"),
                        stats.get("Speed"), stats.get("Power"), stats.get("Value")));
            }
            if (part.get("type").contains("Solid")) {
                allProjectile.put(part.get("Name"), new Projectile(part.get("Name"), part.get("Type"), stats.get("Damage"), stats.get("Piercing"),
                        stats.get("Speed"), stats.get("Power"), stats.get("Value")));
            }
        }
    }

}
