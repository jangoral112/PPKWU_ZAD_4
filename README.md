# DOCUMENTATION
##API

**Application port**: 8081  <br />
**Protocol**: http

### String statistics v1

Returns file in given format containing string statistics

**Path**: /v1/statistics/file/:format <br />
**Method**: POST <br />

**Headers**: <br />
Content-Type: application/json

**Path parameters**: <br />
format: file format (json | txt | xml | csv)

**Request body**:
```
{
    "text": "Text for statistcs",
    "combination": "additional combination of characters to be search for as String"
}
```

### String statistics v2

Returns file in given format containing string statistics

**Path**: /v2/statistics/file/:format <br />
**Method**: POST <br />

**Headers**: <br />
Content-Type: application/json

**Path parameters**: <br />
format: file format (json | txt | xml | csv)

**Request body**:
```
{
    "text": "Text for statistcs",
    "combination": "additional combination of characters to be search for as String"
    "earlyFormat": "csv"
}
```

**Sample response for format JSON for status *OK* *200*:**
```
{
    "uppercase_letters": 12,
    "lowercase_letters": 12,
    "digits": 12,
    "special_characters": 12,
    "combination_hits": 12,
}
```
**Sample response for format txt for status *OK* *200*:**
```
Uppercase letters: 12,
Lowercase letters: 12,
Digits: 12,
Special characters: 12,
Combination hits: 12
```

**Sample response for format xml for status *OK* *200*:**
```
<stringStatistics>
  <uppercaseLetters>12</uppercaseLetters>
  <lowercaseLetters>12</lowercaseLetters>
  <digits>12</digits>
  <specialCharacters>12</specialCharacters>
  <combinationHits>12</combinationHits>
</stringStatistics>
```

**Sample response for format csv for status *OK* *200*:**
```
uppercaseLetters,lowercaseLetters,digits,specialCharacters,combinationHits
12,12,12,12,12
```

##Requirements

Service requires access to service that calculates statistics for string under port `8080` with accessible path `/statistics`