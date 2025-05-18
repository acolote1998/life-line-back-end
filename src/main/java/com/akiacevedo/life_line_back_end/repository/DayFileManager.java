package com.akiacevedo.life_line_back_end.repository;

import com.akiacevedo.life_line_back_end.model.Day;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DayFileManager {

    public static List<Day> ReadDays() {
        ObjectMapper mapper = new ObjectMapper();

        InputStream input = DayFileManager.class.getClassLoader().getResourceAsStream("static/days.json");
        if (input == null) {
            throw new RuntimeException("days.json not found in classpath at static/days.json");
        }

        try {
            List<Day> days = mapper.readValue(input, new TypeReference<List<Day>>() {
            });
            return days;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading days.json", e);
        }
    }

    public static void WriteDays(List<Day> days) {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("src/main/resources/static/days.json");

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, days);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error writing to days.json", e);
        }
    }

}
