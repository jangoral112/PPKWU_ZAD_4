package com.example.zad4;

import org.springframework.stereotype.Service;

@Service
public class FileParsingService {

    public StringStatistics parseFile(String fileFormat, byte[] file) {
        StringStatistics statistics = null;

        switch (fileFormat) {
            case "txt": statistics = parseTextFile(file);
                break;
            case "xml": statistics = parseXmlFile(file);
                break;
            case "json": statistics = parseJsonFile(file);
                break;
            case "csv": statistics = parseCsvFile(file);
                break;
        }

        return statistics;
    }

    private StringStatistics parseTextFile(byte[] file) {

        return null;
    }

    private StringStatistics parseXmlFile(byte[] file) {

        return null;
    }

    private StringStatistics parseJsonFile(byte[] file) {

        return null;
    }

    private StringStatistics parseCsvFile(byte[] file) {

        return null;
    }
}
