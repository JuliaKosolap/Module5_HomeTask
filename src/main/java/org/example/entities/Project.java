package org.example.entities;

import java.time.LocalDate;

public class Project {
    private int id;
    private int client_id;
    private LocalDate start_date;
    private LocalDate finish_date;

    public Project(int id, int client_id, LocalDate start_date, LocalDate finish_date) {
        this.id = id;
        this.client_id = client_id;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return client_id;
    }

    public void setClientId(int client_id) {
        this.client_id = client_id;
    }

    public LocalDate getStartDate() {
        return start_date;
    }

    public void setStartDate(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getFinishDate() {
        return finish_date;
    }

    public void setFinishDate(LocalDate finish_date) {
        this.finish_date = finish_date;
    }
}
