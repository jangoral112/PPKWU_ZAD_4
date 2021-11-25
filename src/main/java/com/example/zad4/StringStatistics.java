package com.example.zad4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StringStatistics {

    private Long uppercaseLetters;

    private Long lowercaseLetters;

    private Long digits;

    private Long specialCharacters;

    private Long combinationHits;

}
