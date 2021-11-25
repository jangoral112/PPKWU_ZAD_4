package com.example.zad4.pattern;

import java.util.regex.Pattern;

public class TxtPattern {

    public static final Pattern UppercaseLettersPattern = Pattern.compile("Uppercase letters:\\s*(\\d+)");

    public static final Pattern LowerLettersPattern = Pattern.compile("Lowercase letters:\\s*(\\d+)");

    public static final Pattern DigitsPattern = Pattern.compile("Digits:\\s*(\\d+)");

    public static final Pattern SpecialCharactersPattern = Pattern.compile("Special characters:\\s*(\\d+)");

    public static final Pattern CombinationHitsPattern = Pattern.compile("Combination hits:\\s*(\\d+)");

}
