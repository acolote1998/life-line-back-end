package com.akiacevedo.life_line_back_end.service;

import com.akiacevedo.life_line_back_end.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayService {
private final DayRepository repository;

@Autowired
    public DayService(DayRepository repository) {
        this.repository = repository;
    }
}
