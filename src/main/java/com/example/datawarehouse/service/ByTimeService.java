package com.example.datawarehouse.service;


import com.example.datawarehouse.dto.MovieCommon;

import java.util.List;

public interface ByTimeService {
    List<MovieCommon> getFilmsByYear(int year);
    List<MovieCommon> getFilmByMonth(int month);
    List<MovieCommon> getFilmsByQuarter(int quarter);

    List<MovieCommon> getFilmsByYearMonth(int year,int month);
    List<MovieCommon> getFilmsByYearQuarter(int year,int quarter);
}
