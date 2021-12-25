package com.example.datawarehouse.service.imp;

import com.example.datawarehouse.dto.MovieCommon;
import com.example.datawarehouse.dao.MovieCommonMapper;
import com.example.datawarehouse.service.ByTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class ByTitleServiceImp implements ByTitleService {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<MovieCommon> getFilmsByTitle(String title) {
        String sql="select title,release_date,rating,producer,language,genre,format_num,asins from " +
                "ans_film_title where title=?";
        PreparedStatementSetter params=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,title);
            }
        };
        MovieCommonMapper rowMapper=new MovieCommonMapper();
        return jdbcTemplate.query(sql, params,rowMapper);
    }
}
