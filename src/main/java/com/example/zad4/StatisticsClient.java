package com.example.zad4;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StatisticsClient {

    private RestTemplate restTemplate = new RestTemplate();

    public byte[] stringStatistics(StatisticsRequest statisticsRequest) {

        RequestEntity<StatisticsRequest> request = RequestEntity
            .post("http://localhost:8081/statistics")
            .headers(headers -> {
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            })
            .body(statisticsRequest);


        return restTemplate.exchange(request, byte[].class).getBody();
    }

}
