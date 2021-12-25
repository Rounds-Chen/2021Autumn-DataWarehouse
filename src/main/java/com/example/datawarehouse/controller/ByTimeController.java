package com.example.datawarehouse.controller;

import com.example.datawarehouse.DTO.MovieCommon;
import com.example.datawarehouse.service.ByTimeService;
import com.example.datawarehouse.util.AjaxJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hive/by-time")
public class ByTimeController {
    @Autowired
    private ByTimeService byTimeService;

    @RequestMapping("/year")
    AjaxJson getByYear(int year){
        try{
            List<MovieCommon> ans=byTimeService.getFilmsByYear(year);
            return AjaxJson.getSuccessData(ans);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/month")
    AjaxJson getByMonth(int month){
        try{
            List<MovieCommon> ans=byTimeService.getFilmByMonth(month);
            return AjaxJson.getSuccessData(ans);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/quarter")
    AjaxJson getByQuarter(int quarter){
        try{
            List<MovieCommon> ans=byTimeService.getFilmsByQuarter(quarter);
            return AjaxJson.getSuccessData(ans);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }


}
