package com.akiacevedo.life_line_back_end.repository;

import com.akiacevedo.life_line_back_end.model.Day;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DayReader {

    public static List<Day> ReadDays() {
        ObjectMapper mapper = new ObjectMapper();

        // Load resource from classpath
        InputStream input = DayReader.class.getClassLoader().getResourceAsStream("static/days.json");
        if (input == null) {
            throw new RuntimeException("days.json not found in classpath at static/days.json");
        }

        try {
            List<Day> days = mapper.readValue(input, new TypeReference<List<Day>>() {});
            return days;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading days.json", e);
        }
    }
}
