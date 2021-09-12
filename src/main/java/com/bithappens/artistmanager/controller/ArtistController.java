package com.bithappens.artistmanager.controller;

import com.bithappens.artistmanager.dto.PostArtistDto;
import com.bithappens.artistmanager.dto.ArtistDto;
import com.bithappens.artistmanager.entity.Artist;
import com.bithappens.artistmanager.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller <> Service <> Repository
@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping(path = "/artists")
    public void addArtist(@RequestBody PostArtistDto postArtistDto) {
        Artist artist = toArtist(postArtistDto);
        artistService.addArtist(artist);
    }
    
    //TODO: @UpdateMapping - поменять name и country

    @PutMapping(path = "/artists/{artistId}")
    public void updateArtist(@PathVariable Long artistId, @RequestBody PostArtistDto postArtistDto ) {
        artistService.updateArtist(artistId, postArtistDto);
    }


    @GetMapping(path = "/artists")
    public List<ArtistDto> findArtists() {
        return artistService.findArtists();
    }

    private Artist toArtist(PostArtistDto postArtistDto) {
        Artist artist = new Artist();
        artist.setName(postArtistDto.getName());
        artist.setCountry(postArtistDto.getCountry());
        return artist;
    }


}
