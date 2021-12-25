package com.example.datawarehouse.service;


import com.example.datawarehouse.dto.MovieCommon;

import java.util.List;

public interface ByTimeService {
    List<MovieCommon> getFilmsByYear(int year);
    List<MovieCommon> getFilmByMonth(int month);
    List<MovieCommon> getFilmsByQuarter(int quarter);
}
