package com.example.zad4.pattern;

import java.util.regex.Pattern;

public class JsonPattern {

    public static final Pattern UppercaseLettersPattern = Pattern.compile("uppercase_letters:\\s*(\\d+)");

    public static final Pattern LowerLettersPattern = Pattern.compile("lowercase_letters:\\s*(\\d+)");

    public static final Pattern DigitsPattern = Pattern.compile("digits:\\s*(\\d+)");

    public static final Pattern SpecialCharactersPattern = Pattern.compile("special_characters:\\s*(\\d+)");

    public static final Pattern CombinationHitsPattern = Pattern.compile("combination_hits:\\s*(\\d+)");

}
