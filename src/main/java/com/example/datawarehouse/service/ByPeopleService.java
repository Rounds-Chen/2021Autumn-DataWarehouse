package com.example.datawarehouse.service;

import com.example.datawarehouse.DTO.MovieActorSimple;
import com.example.datawarehouse.DTO.MovieDirectorSimple;

import java.util.List;

public interface ByPeopleService {
    List<MovieDirectorSimple> getFilmsByDirector(String name);
    List<MovieActorSimple> getFilmsByActor(String name);
}
