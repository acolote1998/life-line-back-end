package com.akiacevedo.life_line_back_end.repository;

import com.akiacevedo.life_line_back_end.model.Day;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DayReader {

    public static List<Day> ReadDays() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File jsonFile = new File("src/main/resources/static/days/days.json");
            List<Day> days = mapper.readValue(jsonFile, new TypeReference<List<Day>>() {});
            return days;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading days.json", e);
        }
    }
}
