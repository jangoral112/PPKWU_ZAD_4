package com.example.zad4.pattern;

import java.util.regex.Pattern;

public class XmlPattern {

    public static final Pattern UppercaseLettersPattern = Pattern.compile("<uppercaseLetters>\\s*(\\d+)</uppercaseLetters>");

    public static final Pattern LowerLettersPattern = Pattern.compile("<lowercaseLetters>\\s*(\\d+)</lowercaseLetters>");

    public static final Pattern DigitsPattern = Pattern.compile("<digits>\\s*(\\d+)</digits>");

    public static final Pattern SpecialCharactersPattern = Pattern.compile("<specialCharacters>\\s*(\\d+)</specialCharacters>");

    public static final Pattern CombinationHitsPattern = Pattern.compile("<combinationHits>\\s*(\\d+)</combinationHits>");

}
