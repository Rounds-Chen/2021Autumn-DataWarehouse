package com.example.datawarehouse.controller;

import com.example.datawarehouse.DTO.MovieCommon;
import com.example.datawarehouse.service.ByTitleService;
import com.example.datawarehouse.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hive/by-title")
public class BYTitleController {
    @Autowired
    ByTitleService byTitleService;

    @RequestMapping("/")
    AjaxJson getFilmByTitle(String title){
        try{
            List<MovieCommon> ans=byTitleService.getFilmsByTitle(title);
            return AjaxJson.getSuccessData(ans);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

}
