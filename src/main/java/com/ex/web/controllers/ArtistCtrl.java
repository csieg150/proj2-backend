package com.ex.web.controllers;

import com.ex.web.models.Artists;
import com.ex.web.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ArtistCtrl {
    
    private ArtistService artistService;
    
    @Autowired
    public ArtistCtrl(ArtistService artistService) {
    	this.artistService = artistService;
    }
    
    
    @GetMapping("/artists")
    public List<Artists> getAllArtists(){
        return artistService.getAllArtists();
    }

}
