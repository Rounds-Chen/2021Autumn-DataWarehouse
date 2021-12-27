package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieCommon;
import com.example.datawarehouse.service.ByTimeService;
import com.example.datawarehouse.util.AjaxJson;

import org.jcodings.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hive/by-time")
@CrossOrigin(origins = "*")
public class ByTimeController {
    @Autowired
    private ByTimeService byTimeService;

    @RequestMapping("/year")
    AjaxJson getByYear(@RequestParam("year") int year){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieCommon> ans=byTimeService.getFilmsByYear(year);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/month")
    AjaxJson getByMonth(@RequestParam("month") int month){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieCommon> ans=byTimeService.getFilmByMonth(month);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<>();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/quarter")
    AjaxJson getByQuarter(@RequestParam("quarter") int quarter){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieCommon> ans=byTimeService.getFilmsByQuarter(quarter);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<>();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/year-quarter")
    AjaxJson getByYearQuarter(@RequestParam("year") int year,@RequestParam("quarter") int quarter){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieCommon> ans=byTimeService.getFilmsByYearQuarter(year,quarter);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<>();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch(Exception e){
            return AjaxJson.getError(e.toString());
        }
    }


    @RequestMapping("/year-month")
    AjaxJson getByYearMonth(@RequestParam("year") int year,@RequestParam("month") int month){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieCommon> ans=byTimeService.getFilmsByYearMonth(year,month);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<>();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch(Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/year-rating")
    AjaxJson getByYearRating(@RequestParam("year") int year){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieCommon> ans=byTimeService.getFilmsByYearRating(year);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<>();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch(Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/year-rating-genre")
    AjaxJson getByYearRating(@RequestParam("year") int year,@RequestParam("genre") String genre){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieCommon> ans=byTimeService.getFilmsByYearGenreRating(year,genre);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<>();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch(Exception e){
            return AjaxJson.getError(e.toString());
        }
    }


}
