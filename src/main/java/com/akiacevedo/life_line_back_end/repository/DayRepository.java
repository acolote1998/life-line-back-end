package com.akiacevedo.life_line_back_end.repository;

import com.akiacevedo.life_line_back_end.model.Day;

import java.util.List;

import static com.akiacevedo.life_line_back_end.repository.DayReader.ReadDays;

public class DayRepository {
    private List<Day> days = ReadDays();
}
