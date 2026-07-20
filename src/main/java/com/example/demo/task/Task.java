package com.example.demo.task;

import java.time.Instant;

public class Task {
    private Long id;
    private String title;
    private String status;
    private Instant createdAt;

    public Task() {}
    public Task(Long id, String title, String status) {
        this.id = id; this.title = title; this.status = status; this.createdAt = Instant.now();
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
