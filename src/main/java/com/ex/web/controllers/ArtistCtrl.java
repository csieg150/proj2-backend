package com.ex.web.controllers;

import com.ex.web.models.Artists;
import com.ex.web.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtistCtrl {
    
    private ArtistService artistService;
    
    @Autowired
    public ArtistCtrl(ArtistService artistService) {
    	this.artistService = artistService;
    }
    
    
    @GetMapping(path="/artists",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Artists>> getAllArtists(){
        return new ResponseEntity<>(artistService.getAllArtists(),HttpStatus.OK);
    }

}
