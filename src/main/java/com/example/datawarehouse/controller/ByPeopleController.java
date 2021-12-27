package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieActorSimple;
import com.example.datawarehouse.dto.MovieDirectorSimple;
import com.example.datawarehouse.service.ByPeopleService;
import com.example.datawarehouse.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hive/by-people")
@CrossOrigin(origins = "*")
public class ByPeopleController {
    @Autowired
    ByPeopleService byPeopleService;

    @RequestMapping("/director")
    AjaxJson getByDirector(@RequestParam("name") String name){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieDirectorSimple> ans=byPeopleService.getFilmsByDirector(name);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<String,Object>();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch(Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/actor")
    AjaxJson getByActor(@RequestParam("name") String name){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieActorSimple> ans=byPeopleService.getFilmsByActor(name);
            Long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<String,Object>();
            res.put("results",ans);
            res.put("time",endTime-startTime);
            return AjaxJson.getSuccessData(res);
        }catch(Exception e){
            return AjaxJson.getError(e.toString());
        }
    }
}
