package com.bithappens.artistmanager.service;

import com.bithappens.artistmanager.dto.ArtistDto;
import com.bithappens.artistmanager.dto.PostArtistDto;
import com.bithappens.artistmanager.entity.Artist;

import java.util.List;


public interface ArtistService {
    List<ArtistDto> findArtists();
    void addArtist(Artist artist);
    void updateArtist(Long artistId, PostArtistDto postArtistDto);
}
