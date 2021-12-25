package com.example.datawarehouse.controller;

import com.example.datawarehouse.DTO.MovieCommon;
import com.example.datawarehouse.service.ByGenreService;
import com.example.datawarehouse.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hive/by-genre")
public class ByGenreController {
    @Autowired
    ByGenreService byGenreService;

    @RequestMapping("/genre")
    AjaxJson getByGenre(String genre){
        try{
            List<MovieCommon> ans=byGenreService.getFilmsByGenre(genre);
            return AjaxJson.getSuccessData(ans);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }
}
