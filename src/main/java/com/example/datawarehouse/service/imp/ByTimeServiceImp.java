package com.example.datawarehouse.service.imp;

import com.example.datawarehouse.DTO.MovieCommon;
import com.example.datawarehouse.dao.MovieCommonMapper;
import com.example.datawarehouse.service.ByTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ByTimeServiceImp implements ByTimeService {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MovieCommon> getFilmsByYear(int year) {
        String sql="select title,release_date,rating,producer,language,genre,format_num,asins from " +
                "ans_film_time where year=?";
        PreparedStatementSetter params=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,year);
            }
        };

        MovieCommonMapper rowMapper=new MovieCommonMapper();
        return jdbcTemplate.query(sql, params,rowMapper);
    }

    @Override
    public List<MovieCommon> getFilmByMonth(int month) {

        String sql="select title,release_date,rating,producer,language,genre,format_num,asins from " +
                "ans_film_time where month=?";
        PreparedStatementSetter params=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,month);
            }
        };

        MovieCommonMapper rowMapper=new MovieCommonMapper();
        return jdbcTemplate.query(sql, params,rowMapper);
    }

    @Override
    public List<MovieCommon> getFilmsByQuarter(int quarter) {
        String sql="select title,release_date,rating,producer,language,genre,format_num,asins from " +
                "ans_film_time where quarter=?";
        PreparedStatementSetter params=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,quarter);
            }
        };

        MovieCommonMapper rowMapper=new MovieCommonMapper();
        return jdbcTemplate.query(sql, params,rowMapper);

    }
}
