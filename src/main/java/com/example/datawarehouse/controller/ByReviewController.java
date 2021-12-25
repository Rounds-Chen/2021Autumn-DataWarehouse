package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieReviewCommon;
import com.example.datawarehouse.dto.MovieSimple;
import com.example.datawarehouse.service.ByReviewService;
import com.example.datawarehouse.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hive/by-review")
public class ByReviewController {
    @Autowired
    ByReviewService byReviewService;

    @RequestMapping("/scores-between")
    AjaxJson getByScoreInterval(@RequestParam("left") float left, @RequestParam("right") float right){
        try{
            List<MovieReviewCommon> ans=byReviewService.getFilmsByScoreInterval(left, right);

            return AjaxJson.getSuccessData(ans);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/score")
    AjaxJson getByScore(@RequestParam("score") float score){
        try{
            List<MovieReviewCommon> ans=byReviewService.getFilmsByScore(score);
            return AjaxJson.getSuccessData(ans);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/rating")
    AjaxJson getByRating(@RequestParam("rating") int rating){
        try{
            List<MovieSimple> ans=byReviewService.getFilmsByRating(rating);
            return AjaxJson.getSuccessData(ans);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }
}
