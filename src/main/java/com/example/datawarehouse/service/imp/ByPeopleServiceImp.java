package com.example.datawarehouse.service.imp;

import com.example.datawarehouse.DTO.MovieActorSimple;
import com.example.datawarehouse.DTO.MovieDirectorSimple;
import com.example.datawarehouse.dao.MovieCommonMapper;
import com.example.datawarehouse.service.ByPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class ByPeopleServiceImp implements ByPeopleService {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MovieDirectorSimple> getFilmsByDirector(String name) {
        String sql="select director_name,film_name,asins from ans_film_director " +
                "where director_name=?";
        PreparedStatementSetter params=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,name);
            }
        };

        MovieCommonMapper rowMapper=new MovieCommonMapper();
        return jdbcTemplate.query(sql, params,rowMapper);
    }

    @Override
    public List<MovieActorSimple> getFilmsByActor(String name) {
        String sql="select actor_name,film_name,asins from ans_film_actor " +
                "where actor_name=?";

        PreparedStatementSetter params=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,name);
            }
        };

        MovieCommonMapper rowMapper=new MovieCommonMapper();
        return jdbcTemplate.query(sql, params,rowMapper);
    }
}
