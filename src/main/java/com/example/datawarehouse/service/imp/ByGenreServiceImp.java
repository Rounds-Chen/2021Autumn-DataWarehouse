package com.example.datawarehouse.service.imp;

import com.example.datawarehouse.dto.MovieCommon;
import com.example.datawarehouse.dao.MovieCommonMapper;
import com.example.datawarehouse.service.ByGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class ByGenreServiceImp implements ByGenreService {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<MovieCommon> getFilmsByGenre(String genre) {
        String sql="select title,release_date,rating,producer,language,genre,format_num,asins from " +
                "ans_film_genre where genre=?";
        PreparedStatementSetter params=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,genre);
            }
        };

        MovieCommonMapper rowMapper=new MovieCommonMapper();
        return jdbcTemplate.query(sql, params,rowMapper);
    }
}
