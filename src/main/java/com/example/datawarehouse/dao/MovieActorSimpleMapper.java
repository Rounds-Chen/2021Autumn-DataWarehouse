package com.example.datawarehouse.dao;

import com.example.datawarehouse.dto.MovieActorSimple;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MovieActorSimpleMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovieActorSimple movieActorSimple=new MovieActorSimple();

        movieActorSimple.setActorName(rs.getString("actor_name"));
        movieActorSimple.setTitle(rs.getString("film_name"));
        String strAsins=rs.getObject("asins").toString();
        List<String> asins= Arrays.asList(strAsins.substring(1,strAsins.length()-1).split(","));
        movieActorSimple.setAsins(asins);

        return movieActorSimple;
    }
}
