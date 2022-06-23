package ness.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Utils {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String getIntervalDuration(String start, String end){
        LocalDateTime startInterval = LocalDateTime.parse(start, formatter);
        LocalDateTime endInterval = LocalDateTime.parse(end, formatter);
        Long hours = ChronoUnit.HOURS.between(startInterval,endInterval);
        Long minutes =ChronoUnit.MINUTES.between(startInterval,endInterval)%60;
        return hours+"h"+minutes+"m";
    }

}
