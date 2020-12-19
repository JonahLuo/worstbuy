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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/poster")
    public ResponseEntity<List<Poster>> list(){
        List<Poster> list = posterService.list();
        return ResponseEntity.ok().body(list);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/poster/{id}")
    public ResponseEntity<Poster> get(@PathVariable("id") String id){
        Poster poster = posterService.get(Long.parseLong(id));
        return ResponseEntity.ok().body(poster);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/poster")
    public ResponseEntity<?> save(@RequestBody Poster poster){
        long id = posterService.save(poster);
        return ResponseEntity.ok().body("Poster created with id: " + id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/poster/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Poster poster){
        posterService.update(Long.parseLong(id), poster);
        return ResponseEntity.ok().body("Poster updated with id: " + id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/poster/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        posterService.delete(Long.parseLong(id));
        return ResponseEntity.ok().body("Poster deleted with id: "+id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/posters")
    public ResponseEntity<List<Poster>> getAllByCategory(@RequestParam("category") String category){
        List<Poster> list = posterService.getAllByCategory(category);
        return ResponseEntity.ok().body(list);
    }
}
