package com.ex.web.controllers;


import com.ex.web.models.Genres;
import com.ex.web.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GenreCtrl {
    private GenreService genreService;
    
    @Autowired
    public GenreCtrl(GenreService genreService) {
    	this.genreService = genreService;
    }
    
    @GetMapping(path="/genres",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Genres>> getAllGenres(){
        return new ResponseEntity<>(genreService.getAllGenres(),HttpStatus.OK);
    }

}
