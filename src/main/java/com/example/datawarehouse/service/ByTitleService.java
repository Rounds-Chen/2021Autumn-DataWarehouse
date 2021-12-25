package com.example.datawarehouse.service;

import com.example.datawarehouse.DTO.MovieCommon;

import java.util.List;

public interface ByTitleService {
    List<MovieCommon> getFilmsByTitle(String title);
}
