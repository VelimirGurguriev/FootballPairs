package com.exam.FootballPairs.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class DateFormatConverter {

    public DateFormatConverter() {
    }

    // Created a list of most date formats.
    static List<DateTimeFormatter> formats = List.of(
            DateTimeFormatter.ofPattern("M/d/yyyy"),
            DateTimeFormatter.ofPattern("M.d.yyyy"),
            DateTimeFormatter.ofPattern("M-d-yyyy"),
            DateTimeFormatter.ofPattern("yyyy.M.d"),
            DateTimeFormatter.ofPattern("yyyy-M-d"),
            DateTimeFormatter.ofPattern("d/M/yyyy"),
            DateTimeFormatter.ofPattern("d-M.yyyy"),
            DateTimeFormatter.ofPattern("d.M.yyyy")
            );

    public static LocalDate convertDateFormat(String inputDate) {
        for (DateTimeFormatter format : formats) {
            try {
                return LocalDate.parse(inputDate, format);
            } catch (DateTimeParseException e) {
            }
        }

        throw new IllegalArgumentException("Invalid date format: " + inputDate);
    }
}
