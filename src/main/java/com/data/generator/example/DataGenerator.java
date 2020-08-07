package com.data.generator.example;

import com.devskiller.jfairy.Fairy;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;

public class DataGenerator {

    private static int ROWS = 10000;
    private static String FILE_NAME = "load_test_random_data.csv";
    private static String HEADER = "random_data";

    public static void main(String[] args) throws IOException {
       final DataGenerator dataGenerator = new DataGenerator();
       dataGenerator.createCSVFile();
    }

    public void createCSVFile() throws IOException {
        FileWriter out = new FileWriter(FILE_NAME);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(HEADER))) {
            for (int i = 0; i < ROWS; i++){
                printer.printRecord(generateText());
            }
        }
    }

    private String generateText(){
        final Fairy fairy = Fairy.create();
        return fairy.textProducer().randomString(1000);
    }
}
