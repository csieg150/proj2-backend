package com.ex.web.controllers;

import com.ex.web.models.Albums;
import com.ex.web.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AlbumCtrl {
    private final AlbumService albumService;

    @Autowired
    public AlbumCtrl(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping(path="/albums",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Albums>> getAllAlbums(){
    	
        return new ResponseEntity<>(albumService.getAllAlbums(),HttpStatus.OK);
    }

}
