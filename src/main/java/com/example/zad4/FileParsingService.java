package com.example.zad4;

import com.example.zad4.pattern.CsvPattern;
import com.example.zad4.pattern.JsonPattern;
import com.example.zad4.pattern.TxtPattern;
import com.example.zad4.pattern.XmlPattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
            .lowercaseLetters(findFirstGroup(file, TxtPattern.LowerLettersPattern))
            .uppercaseLetters(findFirstGroup(file, TxtPattern.UppercaseLettersPattern))
            .digits(findFirstGroup(file, TxtPattern.DigitsPattern))
            .specialCharacters(findFirstGroup(file, TxtPattern.SpecialCharactersPattern))
            .combinationHits(findFirstGroup(file, TxtPattern.CombinationHitsPattern))
            .build();
    }

    private StringStatistics parseXmlFile(String file) {
        return  StringStatistics.builder()
            .lowercaseLetters(findFirstGroup(file, XmlPattern.LowerLettersPattern))
            .uppercaseLetters(findFirstGroup(file, XmlPattern.UppercaseLettersPattern))
            .digits(findFirstGroup(file, XmlPattern.DigitsPattern))
            .specialCharacters(findFirstGroup(file, XmlPattern.SpecialCharactersPattern))
            .combinationHits(findFirstGroup(file, XmlPattern.CombinationHitsPattern))
            .build();
    }

    private StringStatistics parseJsonFile(String file) {
        return  StringStatistics.builder()
            .lowercaseLetters(findFirstGroup(file, JsonPattern.LowerLettersPattern))
            .uppercaseLetters(findFirstGroup(file, JsonPattern.UppercaseLettersPattern))
            .digits(findFirstGroup(file, JsonPattern.DigitsPattern))
            .specialCharacters(findFirstGroup(file, JsonPattern.SpecialCharactersPattern))
            .combinationHits(findFirstGroup(file, JsonPattern.CombinationHitsPattern))
            .build();
    }

    private StringStatistics parseCsvFile(String file) {
        Matcher matcher = CsvPattern.GeneralPattern.matcher(file);
        matcher.find();
        return StringStatistics.builder()
            .lowercaseLetters(Long.parseLong(matcher.group(1)))
            .uppercaseLetters(Long.parseLong(matcher.group(2)))
            .digits(Long.parseLong(matcher.group(3)))
            .specialCharacters(Long.parseLong(matcher.group(4)))
            .combinationHits(Long.parseLong(matcher.group(5)))
            .build();
    }

    private Long findFirstGroup(String text, Pattern pattern) {
        Matcher matcher = pattern.matcher(text);
        matcher.find();
        return Long.parseLong(matcher.group(1));
    }
}
