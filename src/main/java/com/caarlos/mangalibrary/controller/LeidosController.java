package com.caarlos.mangalibrary.controller;

import com.caarlos.mangalibrary.model.Manga;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/leidos")
@CrossOrigin(origins = "http://localhost:5173")

public class LeidosController {

    private final List<Manga> leidos = new CopyOnWriteArrayList<>();

    @GetMapping
    public List<Manga> getLeidos() {
        return leidos;
    }

    @PostMapping
    public ResponseEntity<Void> addLeido(@RequestBody Manga manga) {
        if (manga == null || manga.getMalId() == null) {
            return ResponseEntity.badRequest().build();
        }

        boolean exists = leidos.stream()
                .anyMatch(m -> m.getMalId().equals(manga.getMalId()));

        if (!exists) {
            leidos.add(manga);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{malId}")
    public ResponseEntity<Void> removeLeido(@PathVariable Long malId) {
        boolean removed = leidos.removeIf(m -> m.getMalId().equals(malId));
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
