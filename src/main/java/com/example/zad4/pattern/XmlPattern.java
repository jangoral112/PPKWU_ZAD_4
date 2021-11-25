package com.example.zad4.pattern;

import java.util.regex.Pattern;

public class XmlPattern {

    public static final Pattern UppercaseLettersPattern = Pattern.compile("<uppercaseLetters>\\s*(\\d+)</uppercaseLetters>");

    public static final Pattern LowerLettersPattern = Pattern.compile("<lowercaseLetters>\\s*(\\d+)</lowercaseLetters>");

    public static final Pattern DigitsLettersPattern = Pattern.compile("<digits>\\s*(\\d+)</digits>");

    public static final Pattern SpecialCharactersLettersPattern = Pattern.compile("<specialCharacters>\\s*(\\d+)</specialCharacters>");

    public static final Pattern LettersPattern = Pattern.compile("<combinationHits>\\s*(\\d+)</combinationHits>");

}
