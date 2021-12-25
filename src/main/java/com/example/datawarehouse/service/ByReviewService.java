package com.example.datawarehouse.service;

import com.example.datawarehouse.dto.MovieCommon;
import com.example.datawarehouse.dto.MovieReviewCommon;
import com.example.datawarehouse.dto.MovieSimple;

import java.util.List;

public interface ByReviewService {
    List<MovieReviewCommon> getFilmsByScoreInterval(float left, float right);

    List<MovieReviewCommon> getFilmsByScore(float score);

    List<MovieSimple> getFilmsByRating(int rate);
}
