package com.akiacevedo.life_line_back_end.service;

import com.akiacevedo.life_line_back_end.model.Day;
import com.akiacevedo.life_line_back_end.model.DayRequestDto;
import com.akiacevedo.life_line_back_end.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

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

    public Day createDay(DayRequestDto day) {
        if (day.description().isEmpty() || day.score() <= 0 || day.score() > 10) {
            throw new IllegalArgumentException("Day format is not valid");
        }
        List<Day> oldDays = repository.getDays();
        Day newDay = new Day();
        newDay.setReadOnly(true);
        newDay.setDescription(day.description());
        newDay.setScore(day.score());
        newDay.setId((oldDays.getLast().getId()) + 1);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        newDay.setDate(today.format(formatter));
        List<Day> daysWithoutRepetition = oldDays.stream().filter(oldDay -> !oldDay.getDate().equals(newDay.getDate())).collect(Collectors.toList());
        daysWithoutRepetition.add(newDay);
        repository.setDays(daysWithoutRepetition);
        return newDay;
    }
}