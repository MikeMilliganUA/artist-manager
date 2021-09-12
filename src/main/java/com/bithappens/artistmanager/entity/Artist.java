package com.bithappens.artistmanager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;

}
