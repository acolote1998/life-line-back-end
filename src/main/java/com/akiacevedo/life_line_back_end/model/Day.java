package com.akiacevedo.life_line_back_end.model;

import jakarta.persistence.*;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "read_only")
    private boolean readOnly;

    @Column
    private String description;

    @Column
    private int score;

    @Column
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", readOnly=" + readOnly +
                ", description='" + description + '\'' +
                ", score=" + score +
                ", date='" + date + '\'' +
                '}';
    }
}
