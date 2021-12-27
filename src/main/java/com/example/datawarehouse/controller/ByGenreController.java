package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieCommon;
import com.example.datawarehouse.service.ByGenreService;
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
@RequestMapping("/hive/by-genre")
@CrossOrigin(origins = "*")
public class ByGenreController {
    @Autowired
    ByGenreService byGenreService;

    @RequestMapping("/genre")
    AjaxJson getByGenre(@RequestParam("genre") String genre){
        try{
            long startTime =System.currentTimeMillis();
            List<MovieCommon> ans=byGenreService.getFilmsByGenre(genre);
            long endTime=System.currentTimeMillis();

            Map<String,Object> res=new HashMap<String,Object>();
            res.put("results",ans);
            res.put("time",endTime-startTime);

            return AjaxJson.getSuccessData(res);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }
}
