package com.bithappens.artistmanager.repository;

import com.bithappens.artistmanager.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
