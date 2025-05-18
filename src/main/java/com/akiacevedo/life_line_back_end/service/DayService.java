package com.akiacevedo.life_line_back_end.service;

import com.akiacevedo.life_line_back_end.model.Day;
import com.akiacevedo.life_line_back_end.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayService {
private final DayRepository repository;

@Autowired
    public DayService(DayRepository repository) {
        this.repository = repository;
    }

    public Day getDayById(int id){
        return repository.getDays()
                .stream()
                .filter(day -> day.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public List<Day> getDays(){
    return repository.getDays();
    }

    public List<Day> createDay(Day day){
    List<Day> oldDays = repository.getDays();
    List<Day> daysWithoutRepetition =  oldDays.stream().filter(oldDay -> oldDay.getId()!=day.getId()).collect(Collectors.toList());
    daysWithoutRepetition.add(day);
    repository.setDays(daysWithoutRepetition);
    return repository.getDays();
    }
}
