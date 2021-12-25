package com.example.datawarehouse.service;

import com.example.datawarehouse.DTO.MovieCommon;

import java.util.List;

public interface ByGenreService {
    List<MovieCommon> getFilmsByGenre(String genre);
}
