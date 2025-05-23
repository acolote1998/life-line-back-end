package com.akiacevedo.life_line_back_end.web;

import com.akiacevedo.life_line_back_end.model.Day;
import com.akiacevedo.life_line_back_end.model.DayRequestDto;
import com.akiacevedo.life_line_back_end.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<Day> getDaysById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDayById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createDay(@RequestBody DayRequestDto day) {
        Day createdDay = service.createDay(day);
        return ResponseEntity.created(URI.create("days/" + createdDay.getId())).build();
    }
}
