package com.ex.web.controllers;


import com.ex.web.models.Genres;
import com.ex.web.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GenreCtrl {
    private GenreService genreService;
    
    @Autowired
    public GenreCtrl(GenreService genreService) {
    	this.genreService = genreService;
    }
    
    @GetMapping("/genres")
    public List<Genres> getAllGenres(){
        return genreService.getAllGenres();
    }

}
