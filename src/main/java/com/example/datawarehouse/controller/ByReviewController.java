package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieReviewCommon;
import com.example.datawarehouse.dto.MovieSimple;
import com.example.datawarehouse.service.ByReviewService;
import com.example.datawarehouse.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hive/by-review")
public class ByReviewController {
    @Autowired
    ByReviewService byReviewService;

    @RequestMapping("/scores-between")
    AjaxJson getByScoreInterval(@RequestParam("left") float left, @RequestParam("right") float right){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieReviewCommon> ans=byReviewService.getFilmsByScoreInterval(left, right);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<String,Object>();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/score")
    AjaxJson getByScore(@RequestParam("score") float score){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieReviewCommon> ans=byReviewService.getFilmsByScore(score);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<String,Object>();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/rating")
    AjaxJson getByRating(@RequestParam("rating") int rating){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieSimple> ans=byReviewService.getFilmsByRating(rating);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<>();
            res.put("results",ans);
            res.put("time",endTime-startTime);
            return AjaxJson.getSuccessData(res);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }
}
