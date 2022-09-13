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

    private static boolean isDataLoaded;

    private static final String DATA_FILE = "src/resources/part_data.csv";

    private static ArrayList<Map<String, String>> allParts;
    public static final HashMap<String, Casing> allCasings = new HashMap<>();
    public static final HashMap<String, Dust> allDust = new HashMap<>();
    public static final HashMap<String, Powder> allPowder = new HashMap<>();
    public static final HashMap<String, Primer> allPrimer = new HashMap<>();
    public static final HashMap<String, Projectile> allProjectile = new HashMap<>();
    public static final HashMap<String, Shape> allShape = new HashMap<>();

    //Copied from techjobs-console-java, modified
    private static void loadData() {

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

    private static boolean isNumeric(String strNum) {
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

    private static double makeDouble(String strNum) {
        if (strNum.length() == 0) {
            return 0;
        }
        return Double.parseDouble(strNum);
    }

    private static double numberifyCash(String money) {
        if (money.length() == 0) {
            return 0;
        }
        return makeDouble(money.substring(2));
    }

    public static void loadPartData() {
        loadData();
        for (Map<String, String> part : allParts) {
            //Sort into Projectiles
            if (part.get("Type").contains("Solid")) {
                allProjectile.put(part.get("Name"), new Projectile(part.get("Name"), part.get("Type"), makeDouble(part.get("Damage")), makeDouble(part.get("Piercing")),
                        makeDouble(part.get("Speed")), makeDouble(part.get("Power")), numberifyCash(part.get("Value"))));
            }
            //Sort into Shapes
            if (part.get("Type").contains("Shape")) {
                allShape.put(part.get("Name"), new Shape(part.get("Name"), makeDouble(part.get("Damage")), makeDouble(part.get("Piercing")),
                        makeDouble(part.get("Speed")), makeDouble(part.get("Power")), numberifyCash(part.get("Value"))));
            }

            //Sort into Dusts/Oils
            if (part.get("Type").contains("Dust") || part.get("Type").contains("Oil")) {
                allDust.put(part.get("Name"), new Dust(part.get("Name"), part.get("Type"), makeDouble(part.get("Damage")), makeDouble(part.get("Piercing")),
                        makeDouble(part.get("Speed")), makeDouble(part.get("Power")), numberifyCash(part.get("Value"))));
            }
            //Sort into Powders
            if (part.get("Type").contains("Powder")) {
                allPowder.put(part.get("Name"), new Powder(part.get("Name"), makeDouble(part.get("Damage")), makeDouble(part.get("Piercing")),
                        makeDouble(part.get("Speed")), makeDouble(part.get("Power")), numberifyCash(part.get("Value"))));
            }
            //Sort into Primers
            if (part.get("Type").contains("Primer")) {
                allPrimer.put(part.get("Name"), new Primer(part.get("Name"), makeDouble(part.get("Damage")), makeDouble(part.get("Piercing")),
                        makeDouble(part.get("Speed")), makeDouble(part.get("Power")), numberifyCash(part.get("Value"))));
            }
            //Sort into Casings
            if (part.get("Type").contains("Casing")) {
                allCasings.put(part.get("Name"), new Casing(part.get("Name"), makeDouble(part.get("Damage")), makeDouble(part.get("Piercing")),
                        makeDouble(part.get("Speed")), makeDouble(part.get("Power")), numberifyCash(part.get("Value"))));
            }
        }
    }

}
