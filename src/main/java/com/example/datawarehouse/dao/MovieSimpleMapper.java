package com.example.datawarehouse.dao;

import com.example.datawarehouse.dto.MovieCommon;
import com.example.datawarehouse.dto.MovieSimple;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MovieSimpleMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovieSimple movieCommon=new MovieSimple();
        movieCommon.setTitle(rs.getString("title"));
        movieCommon.setGenre(rs.getString("genre"));
        movieCommon.setRating(rs.getString("rating"));
        movieCommon.setReleaseDate(rs.getString("release_date"));
        String strAsins=rs.getObject("asins").toString();
        List<String> asins= Arrays.asList(strAsins.substring(1,strAsins.length()-1).split(","));
        movieCommon.setAsins(asins);
        return movieCommon;
    }
}
