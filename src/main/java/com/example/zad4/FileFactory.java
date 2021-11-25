package com.example.zad4;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.springframework.stereotype.Component;

@Component
public class FileFactory {

    public InputStream createFile(String format, StringStatistics statistics) {
        InputStream inputStream = null;

        switch (format) {
            case "txt": inputStream = createTextFile(statistics);
                break;
            case "xml": inputStream = createXmlFile(statistics);
                break;
            case "json": inputStream = createJsonFile(statistics);
                break;
            case "csv": inputStream = createCsvFile(statistics);
                break;
        }

        return inputStream;
    }

    private InputStream createTextFile(StringStatistics statistics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Uppercase letters: ")
            .append(statistics.getUppercaseLetters())
            .append("\n")
            .append("Lowercase letters: ")
            .append(statistics.getLowercaseLetters())
            .append("\n")
            .append("Digits: ")
            .append(statistics.getDigits())
            .append("\n")
            .append("Special characters: ")
            .append(statistics.getSpecialCharacters())
            .append("\n")
            .append("Combination hits: ")
            .append(statistics.getCombinationHits())
            .append("\n");

        return new ByteArrayInputStream(stringBuilder.toString().getBytes());
    }

    private InputStream createXmlFile(StringStatistics statistics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
            .append("<statistics>")
                .append("\n")
                .append("<uppercaseLetters>")
                .append(statistics.getUppercaseLetters())
                .append("</uppercaseLetters>")
                .append("\n")
                .append("<lowercaseLetters>")
                .append(statistics.getLowercaseLetters())
                .append("</lowercaseLetters>")
                .append("\n")
                .append("<digits>")
                .append(statistics.getDigits())
                .append("</digits>")
                .append("\n")
                .append("<specialCharacters>")
                .append(statistics.getSpecialCharacters())
                .append("</specialCharacters>")
                .append("\n")
                .append("<combinationHits>")
                .append(statistics.getCombinationHits())
                .append("</combinationHits>")
                .append("\n")
            .append("</statistics>");

        return new ByteArrayInputStream(stringBuilder.toString().getBytes());
    }

    private InputStream createJsonFile(StringStatistics statistics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{")
            .append("\"uppercase_letters:\" ")
            .append(statistics.getUppercaseLetters())
            .append("\n")
            .append("\"lowercase_letters:\" ")
            .append(statistics.getLowercaseLetters())
            .append("\n")
            .append("\"digits: \" ")
            .append(statistics.getDigits())
            .append("\n")
            .append("\"special_characters:\" ")
            .append(statistics.getSpecialCharacters())
            .append("\n")
            .append("\"combination_hits:\" ")
            .append(statistics.getCombinationHits())
            .append("\n")
            .append("}");

        return new ByteArrayInputStream(stringBuilder.toString().getBytes());
    }

    private InputStream createCsvFile(StringStatistics statistics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
            .append("uppercase_letters,")
            .append("lowercase_letters,")
            .append("digits,")
            .append("special_characters,")
            .append("combination_hits:")
            .append("\n")
            .append(statistics.getUppercaseLetters())
            .append(",")
            .append(statistics.getLowercaseLetters())
            .append(",")
            .append(statistics.getDigits())
            .append(",")
            .append(statistics.getSpecialCharacters())
            .append(",")
            .append(statistics.getCombinationHits())
            .append("\n");

        return new ByteArrayInputStream(stringBuilder.toString().getBytes());
    }

}
