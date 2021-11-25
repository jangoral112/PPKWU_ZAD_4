package com.example.zad4;

import com.example.zad4.pattern.CsvPattern;
import com.example.zad4.pattern.JsonPattern;
import com.example.zad4.pattern.TxtPattern;
import com.example.zad4.pattern.XmlPattern;
import java.util.regex.Matcher;
import org.springframework.stereotype.Service;

@Service
public class FileParsingService {

    public StringStatistics parseFile(String fileFormat, byte[] file) {
        StringStatistics statistics = null;
        String fileAsString = new String(file);

        switch (fileFormat) {
            case "txt": statistics = parseTextFile(fileAsString);
                break;
            case "xml": statistics = parseXmlFile(fileAsString);
                break;
            case "json": statistics = parseJsonFile(fileAsString);
                break;
            case "csv": statistics = parseCsvFile(fileAsString);
                break;
        }

        return statistics;
    }

    private StringStatistics parseTextFile(String file) {
        return  StringStatistics.builder()
            .lowercaseLetters(Long.parseLong(TxtPattern.LowerLettersPattern.matcher(file).group(0)))
            .uppercaseLetters(Long.parseLong(TxtPattern.UppercaseLettersPattern.matcher(file).group(0)))
            .digits(Long.parseLong(TxtPattern.DigitsPattern.matcher(file).group(0)))
            .specialCharacters(Long.parseLong(TxtPattern.SpecialCharactersPattern.matcher(file).group(0)))
            .combinationHits(Long.parseLong(TxtPattern.CombinationHitsPattern.matcher(file).group(0)))
            .build();
    }

    private StringStatistics parseXmlFile(String file) {
        return  StringStatistics.builder()
            .lowercaseLetters(Long.parseLong(XmlPattern.LowerLettersPattern.matcher(file).group(0)))
            .uppercaseLetters(Long.parseLong(XmlPattern.UppercaseLettersPattern.matcher(file).group(0)))
            .digits(Long.parseLong(XmlPattern.DigitsPattern.matcher(file).group(0)))
            .specialCharacters(Long.parseLong(XmlPattern.SpecialCharactersPattern.matcher(file).group(0)))
            .combinationHits(Long.parseLong(XmlPattern.CombinationHitsPattern.matcher(file).group(0)))
            .build();
    }

    private StringStatistics parseJsonFile(String file) {
        return StringStatistics.builder()
            .lowercaseLetters(Long.parseLong(JsonPattern.LowerLettersPattern.matcher(file).group(0)))
            .uppercaseLetters(Long.parseLong(JsonPattern.UppercaseLettersPattern.matcher(file).group(0)))
            .digits(Long.parseLong(JsonPattern.DigitsPattern.matcher(file).group(0)))
            .specialCharacters(Long.parseLong(JsonPattern.SpecialCharactersPattern.matcher(file).group(0)))
            .combinationHits(Long.parseLong(JsonPattern.CombinationHitsPattern.matcher(file).group(0)))
            .build();
    }

    private StringStatistics parseCsvFile(String file) {
        Matcher matcher = CsvPattern.GeneralPattern.matcher(file);

        return StringStatistics.builder()
            .lowercaseLetters(Long.parseLong(matcher.group(0)))
            .uppercaseLetters(Long.parseLong(matcher.group(1)))
            .digits(Long.parseLong(matcher.group(2)))
            .specialCharacters(Long.parseLong(matcher.group(3)))
            .combinationHits(Long.parseLong(matcher.group(4)))
            .build();
    }
}
