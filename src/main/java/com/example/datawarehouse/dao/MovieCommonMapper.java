package com.example.datawarehouse.dao;

import com.example.datawarehouse.DTO.MovieCommon;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MovieCommonMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovieCommon movieCommon=new MovieCommon();
        movieCommon.setTitle(rs.getString("title"));
        movieCommon.setFormatNum(rs.getString("format_num"));
        movieCommon.setGenre(rs.getString("genre"));
        movieCommon.setLanguage(rs.getString("language"));
        movieCommon.setProducer(rs.getString("producer"));
        movieCommon.setRating(rs.getString("rating"));
        movieCommon.setReleaseDate(rs.getString("release_date"));
        String strAsins=rs.getObject("asins").toString();
        List<String> asins= Arrays.asList(strAsins.substring(1,strAsins.length()-1).split(","));
        movieCommon.setAsins(asins);

//        System.out.println("asins:"+rs.getObject("asins").toString());
//        movieCommon.setAsins((List<String>) rs.getObject("asins"));
        return movieCommon;
    }
}
