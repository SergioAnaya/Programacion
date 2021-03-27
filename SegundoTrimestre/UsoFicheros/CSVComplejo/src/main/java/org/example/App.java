package org.example;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class App {

    private final static char SEPARADOR = ',';
    private final static char COMILLA = '"';



    public static void main( String[] args ) throws IOException {

        String dir = System.getProperty("user.dir");
        FileReader lectorArchivo = new FileReader(dir + File.separator + "datos.csv");

        CSVParser parserConPuntoYComa = new CSVParserBuilder().withSeparator(SEPARADOR)
                                                              .withQuoteChar(COMILLA)
                                                              .build();

        CSVReader lectorCSV = new CSVReaderBuilder(lectorArchivo).withCSVParser(parserConPuntoYComa)
                                                                 .withSkipLines(1) // Sirve para saltar la primera fila indicando que es una cabecera
                                                                 .build();

        List<String []> fila = lectorCSV.readAll();
    }
}