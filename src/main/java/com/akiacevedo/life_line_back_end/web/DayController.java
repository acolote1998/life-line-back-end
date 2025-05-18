package com.akiacevedo.life_line_back_end.web;

import com.akiacevedo.life_line_back_end.model.Day;
import com.akiacevedo.life_line_back_end.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/days")
public class DayController {

    private final DayService service;

    @Autowired
    public DayController(DayService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Day>> getDays() {
        return ResponseEntity.ok(service.getDays());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Day> getDaysById(@PathVariable int id) {
        return ResponseEntity.ok(service.getDayById(id));
    }
}
