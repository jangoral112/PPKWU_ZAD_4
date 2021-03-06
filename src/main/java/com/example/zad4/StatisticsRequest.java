package com.example.zad4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsRequest {

    private String text;

    private String combination;

    private String earlyFormat;
}