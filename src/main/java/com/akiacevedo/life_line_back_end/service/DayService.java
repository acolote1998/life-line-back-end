package com.akiacevedo.life_line_back_end.service;

import com.akiacevedo.life_line_back_end.model.Day;
import com.akiacevedo.life_line_back_end.model.DayRequestDto;
import com.akiacevedo.life_line_back_end.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayService {
    private final DayRepository repository;

    @Autowired
    public DayService(DayRepository repository) {
        this.repository = repository;
    }

    public Day getDayById(int id) {
        return repository.getDays()
                .stream()
                .filter(day -> day.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Day> getDays() {
        return repository.getDays();
    }

    public void createDay(DayRequestDto day) {
        List<Day> oldDays = repository.getDays();
        Day newDay = new Day();
        newDay.setDescription(day.description());
        newDay.setScore(day.score());
        newDay.setId((oldDays.getLast().getId()) + 1);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        newDay.setDate(today.format(formatter));
        List<Day> daysWithoutRepetition = oldDays.stream().filter(oldDay -> oldDay.getId() != newDay.getId()).collect(Collectors.toList());
        daysWithoutRepetition.add(newDay);
        repository.setDays(daysWithoutRepetition);
    }
}

/*
    private int id;
    private boolean readOnly;
    private String description;
    private int score;
    private String date;
 */