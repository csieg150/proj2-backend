package com.ex.web.controllers;

import com.ex.web.models.Albums;
import com.ex.web.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AlbumCtrl {
    private final AlbumService albumService;

    @Autowired
    public AlbumCtrl(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    public List<Albums> getAllAlbums(){
        return albumService.getAllAlbums();
    }

}
