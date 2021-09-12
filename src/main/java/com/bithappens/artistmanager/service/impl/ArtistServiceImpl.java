package com.bithappens.artistmanager.service.impl;

import com.bithappens.artistmanager.dto.ArtistDto;
import com.bithappens.artistmanager.dto.PostArtistDto;
import com.bithappens.artistmanager.entity.Artist;
import com.bithappens.artistmanager.repository.ArtistRepository;
import com.bithappens.artistmanager.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;


    @Override
    public List<ArtistDto> findArtists() {
        return artistRepository
                .findAll()
                .stream()
                .map(this::artistEntityToArtistDto)
                .collect(toList());
    }

    @Override
    public void addArtist(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public void updateArtist(Long artistId, PostArtistDto postArtistDto) {
            Artist artist = new Artist();
            artist.setId(artistId);
            artist.setName(postArtistDto.getName());
            artist.setCountry(postArtistDto.getCountry());
            artistRepository.save(artist);
    }

    private ArtistDto artistEntityToArtistDto(Artist artist) {
        ArtistDto dto = new ArtistDto();
        dto.setId(artist.getId());
        dto.setName(artist.getName());
        dto.setCountry(artist.getCountry());
        return dto;
    }


}
