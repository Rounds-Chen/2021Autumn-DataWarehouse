package com.example.datawarehouse.dao;

import com.example.datawarehouse.DTO.MovieDirectorSimple;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MovieDirectorSimpleMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovieDirectorSimple movieDirectorSimple=new MovieDirectorSimple();

        movieDirectorSimple.setTitle(rs.getString("film_name"));
        movieDirectorSimple.setPeopleName(rs.getString("director_name"));
        String strAsins=rs.getObject("asins").toString();
        List<String> asins= Arrays.asList(strAsins.substring(1,strAsins.length()-1).split(","));
        movieDirectorSimple.setAsins(asins);

        return movieDirectorSimple;
    }
}
