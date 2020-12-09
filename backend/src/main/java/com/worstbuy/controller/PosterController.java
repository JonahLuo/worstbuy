package com.worstbuy.controller;

import com.worstbuy.model.Poster;
import com.worstbuy.service.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PosterController {
    private PosterService posterService;

    @Autowired
    public PosterController(PosterService posterService) {
        this.posterService = posterService;
    }

    @GetMapping("/poster")
    public ResponseEntity<List<Poster>> list(){
        List<Poster> list = posterService.list();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/poster/{id}")
    public ResponseEntity<Poster> get(@PathVariable("id") long id){
        Poster poster = posterService.get(id);
        return ResponseEntity.ok().body(poster);
    }

    @PostMapping("/poster")
    public ResponseEntity<?> save(@RequestBody Poster poster){
        long id = posterService.save(poster);
        return ResponseEntity.ok().body("Poster created with id: " + id);
    }

    @PutMapping("/poster/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Poster poster){
        posterService.update(id, poster);
        return ResponseEntity.ok().body("Poster updated with id: " + id);
    }

    @DeleteMapping("/poster/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        posterService.delete(id);
        return ResponseEntity.ok().body("Poster deleted with id: "+id);
    }
}
