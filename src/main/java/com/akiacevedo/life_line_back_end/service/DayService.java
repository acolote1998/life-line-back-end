package com.akiacevedo.life_line_back_end.service;

import com.akiacevedo.life_line_back_end.model.Day;
import com.akiacevedo.life_line_back_end.model.DayRequestDto;
import com.akiacevedo.life_line_back_end.model.User;
import com.akiacevedo.life_line_back_end.repository.DayRepository;
import com.akiacevedo.life_line_back_end.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DayService {
    private final DayRepository repository;
    private final UserRepository userRepository;

    public DayService(DayRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


    public Day getDayByUserAndId(Long id, String userId) {
        return repository.findDayByIdAndUser_Id(id, userId);
    }

    public List<Day> getDaysByUser(String userId) {
        return repository.findAllByUser_Id(userId);
    }

    @Transactional
    public Day createDay(DayRequestDto day, String ownerId, String ownerName) {
        if (day.description().isEmpty() || day.score() <= 0 || day.score() > 10) {
            throw new IllegalArgumentException("Day format is not valid");
        }
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String todayFormatedDate = today.format(formatter);
        if (repository.findDayByDate(todayFormatedDate) != null) {
            repository.removeDayByDate(todayFormatedDate);
        }
        User user = userRepository.findById(ownerId).orElse(null);
        if (user == null) {
            user = new User();
            user.setId(ownerId);
            user.setName(ownerName);
            userRepository.save(user);
        }
        Day newDay = new Day();
        newDay.setReadOnly(true);
        newDay.setDate(todayFormatedDate);
        newDay.setScore(day.score());
        newDay.setDescription(day.description());
        newDay.setUser(user);
        return repository.save(newDay);
    }
}