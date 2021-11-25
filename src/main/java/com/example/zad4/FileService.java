package com.example.zad4;

import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private StatisticsClient statisticsClient;

    @Autowired
    FileParsingService fileParsingService;

    @Autowired
    private FileFactory fileFactory;

    public InputStream stringStatisticsAsFile(String format, StatisticsRequest request) {
        byte[] file = statisticsClient.stringStatistics(request);
        StringStatistics statistics = fileParsingService.parseFile(request.getEarlyFormat(), file);

        return fileFactory.createFile(format, statistics);
    }
}
