package com.akiacevedo.life_line_back_end.service;

import com.akiacevedo.life_line_back_end.model.Day;
import com.akiacevedo.life_line_back_end.model.DayRequestDto;
import com.akiacevedo.life_line_back_end.repository.DayRepository;
import jakarta.transaction.Transactional;
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

    public Day getDayById(Long id) {
        return repository.findDayById(id);
    }

    public List<Day> getDays() {
        return repository.findAll();
    }

    @Transactional
    public Day createDay(DayRequestDto day) {
        if (day.description().isEmpty() || day.score() <= 0 || day.score() > 10) {
            throw new IllegalArgumentException("Day format is not valid");
        }
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String todayFormatedDate = today.format(formatter);
        if (repository.findDayByDate(todayFormatedDate) != null) {
            repository.removeDayByDate(todayFormatedDate);
        }
        Day newDay = new Day();
        newDay.setReadOnly(true);
        newDay.setDate(todayFormatedDate);
        newDay.setScore(day.score());
        newDay.setDescription(day.description());
        return repository.save(newDay);
    }
}