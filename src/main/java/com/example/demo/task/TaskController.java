package com.example.demo.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final Map<Long, Task> store = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    private static final Set<String> VALID_STATUSES = Set.of("todo", "in_progress", "done");

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        Long id = counter.getAndIncrement();
        task.setId(id);
        task.setCreatedAt(java.time.Instant.now());
        if (task.getStatus() == null) task.setStatus("todo");
        if (!VALID_STATUSES.contains(task.getStatus())) {
            return ResponseEntity.badRequest().build();
        }
        store.put(id, task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping
    public List<Task> list(@RequestParam(required = false) String status) {
        return store.values().stream()
                .filter(t -> status == null || status.equals(t.getStatus()))
                .sorted(Comparator.comparing(Task::getId))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable Long id) {
        Task t = store.get(id);
        return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Task t = store.get(id);
        if (t == null) return ResponseEntity.notFound().build();
        String newStatus = body.get("status");
        if (newStatus == null || !VALID_STATUSES.contains(newStatus)) {
            return ResponseEntity.badRequest().build();
        }
        t.setStatus(newStatus);
        return ResponseEntity.ok(t);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return store.remove(id) != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
