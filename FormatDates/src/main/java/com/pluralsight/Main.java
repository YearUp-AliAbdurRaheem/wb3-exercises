package com.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        // Get the current date and time
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZonedDateTime currentGMT = ZonedDateTime.now(ZoneOffset.UTC);
        ZonedDateTime currentLocalTime = ZonedDateTime.now();

        // Set all of dates and times
        // The info on how to do it like this was found at https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm").withZone(ZoneOffset.UTC);
        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("HH:mm 'on' dd-MMM-yyyy").withZone(currentLocalTime.getZone());

        // sout the dates and times
        System.out.printf(
                "Current Date in all formats:%n%s%n%s%n%s%n%s%n%s%n", // does this count as readable lol
                currentDate.format(formatter1),  
                currentDate.format(formatter2), 
                currentDate.format(formatter3),  
                currentGMT.format(formatter4),
                currentLocalTime.format(formatter5)
        );      
    }
}