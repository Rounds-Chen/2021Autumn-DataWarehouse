package com.example.datawarehouse.service;

import com.example.datawarehouse.dto.MovieCommon;

import java.util.List;

public interface ByTitleService {
    List<MovieCommon> getFilmsByTitle(String title);
}
