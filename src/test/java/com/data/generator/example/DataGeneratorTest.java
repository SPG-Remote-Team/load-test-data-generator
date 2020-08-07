package com.data.generator.example;

import com.google.common.collect.Lists;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static com.google.common.collect.Lists.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DataGeneratorTest {

    @Test
    public void testGenerateCsvFile() throws IOException {
        new DataGenerator().createCSVFile();

        final Reader in = new FileReader("load_test_random_data.csv");
        final Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader("random_data")
                .withFirstRecordAsHeader()
                .parse(in);

        assertThat(newArrayList(records).size(), is(10000));
    }

}