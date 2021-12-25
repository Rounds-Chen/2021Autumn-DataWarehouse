package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieActorSimple;
import com.example.datawarehouse.dto.MovieDirectorSimple;
import com.example.datawarehouse.service.ByPeopleService;
import com.example.datawarehouse.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hive/by-people")
public class ByPeopleController {
    @Autowired
    ByPeopleService byPeopleService;

    @RequestMapping("/director")
    AjaxJson getByDirector(@RequestParam("name") String name){
        try{
            List<MovieDirectorSimple> ans=byPeopleService.getFilmsByDirector(name);
            return AjaxJson.getSuccessData(ans);
        }catch(Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @RequestMapping("/actor")
    AjaxJson getByActor(@RequestParam("name") String name){
        try{
            List<MovieActorSimple> ans=byPeopleService.getFilmsByActor(name);
            return AjaxJson.getSuccessData(ans);
        }catch(Exception e){
            return AjaxJson.getError(e.toString());
        }
    }
}
