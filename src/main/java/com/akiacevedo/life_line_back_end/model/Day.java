package com.akiacevedo.life_line_back_end.model;

public class Day {
    private int id;
    private boolean readOnly;
    private String description;
    private int score;
    private String date;

    public Day(int id, boolean readOnly, String description, int score, String date) {
        this.id = id;
        this.readOnly = readOnly;
        this.description = description;
        this.score = score;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
