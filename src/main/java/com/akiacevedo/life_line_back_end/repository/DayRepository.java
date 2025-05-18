package com.akiacevedo.life_line_back_end.repository;

import com.akiacevedo.life_line_back_end.model.Day;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.akiacevedo.life_line_back_end.repository.DayFileManager.ReadDays;

@Repository
public class DayRepository {
    private List<Day> days = ReadDays();

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }
}
