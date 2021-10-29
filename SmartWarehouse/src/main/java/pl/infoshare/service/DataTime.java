package pl.infoshare.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DataTime {

    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_TIME;
        String timeOK = now.truncatedTo(ChronoUnit.SECONDS).format(dtf);
        return timeOK;
    }
}
