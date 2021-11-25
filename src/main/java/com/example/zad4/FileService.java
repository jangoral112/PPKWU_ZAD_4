package com.example.zad4;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @SneakyThrows
    public InputStream convertStringStatisticsFile(String format, MultipartFile file) {
        Pattern fileFormatPattern = Pattern.compile("\\.(.*)$");

        Matcher matcher = fileFormatPattern.matcher(file.getOriginalFilename());
        matcher.find();
        String originalFileFormat = matcher.group(1);

        byte[] fileInBytes = file.getBytes();
        StringStatistics statistics = fileParsingService.parseFile(originalFileFormat, fileInBytes);

        return fileFactory.createFile(format, statistics);
    }
}
