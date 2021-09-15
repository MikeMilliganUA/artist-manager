package com.bithappens.artistmanager.repository;

import com.bithappens.artistmanager.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Modifying
    @Query("update Artist a set a.name = :name, a.country = :country where a.id = :id")
    void updateArtist(Long artistId, String name, String country);
}
