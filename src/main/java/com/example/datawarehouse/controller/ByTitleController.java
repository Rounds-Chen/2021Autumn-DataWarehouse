package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieCommon;
import com.example.datawarehouse.service.ByTitleService;
import com.example.datawarehouse.util.AjaxJson;
import org.apache.hadoop.util.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hive/by-title")
public class ByTitleController {
    @Autowired
    ByTitleService byTitleService;

    @RequestMapping("/")
    AjaxJson getFilmByTitle(@RequestParam("title") String title){
        try{
            Long startTime=System.currentTimeMillis();
            List<MovieCommon> ans=byTitleService.getFilmsByTitle(title);
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
