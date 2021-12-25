package com.example.datawarehouse.service.imp;

import com.example.datawarehouse.dao.MovieSimpleMapper;
import com.example.datawarehouse.dto.MovieCommon;
import com.example.datawarehouse.dto.MovieReviewCommon;
import com.example.datawarehouse.dao.MovieReviewCommonMapper;
import com.example.datawarehouse.dto.MovieSimple;
import com.example.datawarehouse.service.ByReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class ByReviewServiceImp implements ByReviewService {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MovieReviewCommon> getFilmsByScoreInterval(float left, float right) {
        String sql="select title,release_date,rating,producer,language,genre,format_num,avg_overall,asins from " +
                "ans_film_avg_overall where avg_overall<=? and avg_overall>=?";

        PreparedStatementSetter params=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setFloat(1,right);
                ps.setFloat(2,left);
            }
        };

        MovieReviewCommonMapper rowMapper=new MovieReviewCommonMapper();
        return jdbcTemplate.query(sql, params,rowMapper);
    }

    @Override
    public List<MovieReviewCommon> getFilmsByScore(float score) {
        String sql="select title,release_date,rating,producer,language,genre,format_num,avg_overall,asins from " +
                "ans_film_avg_overall where avg_overall=?";

        PreparedStatementSetter params=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setFloat(1,score);
            }
        };

        MovieReviewCommonMapper rowMapper=new MovieReviewCommonMapper();
        return jdbcTemplate.query(sql, params,rowMapper);
    }

    @Override
    public List<MovieSimple> getFilmsByRating(int rate) {
        String sql="select title,release_date,rating,genre,asins from " +
                "ans_film_title where rate=?";
        PreparedStatementSetter params=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,rate);
            }
        };

        MovieSimpleMapper rowMapper=new MovieSimpleMapper();
        return jdbcTemplate.query(sql, params,rowMapper);
    }
}
