package com.example.datawarehouse.service;

import com.example.datawarehouse.dto.MovieActorSimple;
import com.example.datawarehouse.dto.MovieDirectorSimple;

import java.util.List;

public interface ByPeopleService {
    List<MovieDirectorSimple> getFilmsByDirector(String name);
    List<MovieActorSimple> getFilmsByActor(String name);
}
