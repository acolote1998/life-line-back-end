package com.akiacevedo.life_line_back_end.repository;

import com.akiacevedo.life_line_back_end.model.Day;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface DayRepository extends ListCrudRepository<Day, Long> {
    List<Day> findAll();

    Day findDayById(Long id);

    List<Day> findDayByDate(String date);

    void removeDayByDate(String date);
}
