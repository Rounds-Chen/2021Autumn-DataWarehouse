package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieCommon;
import com.example.datawarehouse.service.ByTitleService;
import com.example.datawarehouse.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hive/by-title")
public class ByTitleController {
    @Autowired
    ByTitleService byTitleService;

    @RequestMapping("/")
    AjaxJson getFilmByTitle(@RequestParam("title") String title){
        try{
            List<MovieCommon> ans=byTitleService.getFilmsByTitle(title);
            return AjaxJson.getSuccessData(ans);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

}
