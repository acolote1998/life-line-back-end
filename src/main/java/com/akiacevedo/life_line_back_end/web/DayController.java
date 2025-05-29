package com.akiacevedo.life_line_back_end.web;

import com.akiacevedo.life_line_back_end.model.Day;
import com.akiacevedo.life_line_back_end.model.DayRequestDto;
import com.akiacevedo.life_line_back_end.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
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

    @GetMapping("/byUser")
    public ResponseEntity<List<Day>> getDaysByUser(@AuthenticationPrincipal Jwt jwt) {
        String dayOwnerId = jwt.getSubject();
        return ResponseEntity.ok(service.getDaysByUser(dayOwnerId));
    }

    @GetMapping("/byUser/{id}")
    public ResponseEntity<Day> getDaysByUserAndId(@AuthenticationPrincipal Jwt jwt, @PathVariable Long id) {
        String dayOwnerId = jwt.getSubject();
        return ResponseEntity.ok(service.getDayByUserAndId(id, dayOwnerId));
    }

    @PostMapping
    public ResponseEntity<Void> createDay(@AuthenticationPrincipal Jwt jwt, @RequestBody DayRequestDto day) {
        String dayOwnerId = jwt.getSubject();
        String ownerName = jwt.getClaimAsString("name");
        Day createdDay = service.createDay(day, dayOwnerId, ownerName);
        return ResponseEntity.created(URI.create("days/" + createdDay.getId())).build();
    }
}
